package com.diskvarko.androidacademyapp.movieList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.diskvarko.androidacademyapp.R
import com.diskvarko.androidacademyapp.data.Movie
import com.diskvarko.androidacademyapp.databinding.FragmentMoviesListBinding
import com.diskvarko.androidacademyapp.movieDetails.MoviesDetailsFragment

class MoviesListFragment() : Fragment(), MoviesAdapter.OnMovieClickListener {

    private val movieListViewModel: MoviesViewModel by viewModels()
    {
        MovieListViewModelFactory(MoviesInteractor())
    }
    private val binding: FragmentMoviesListBinding get() = _binding!!
    private var _binding: FragmentMoviesListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieListViewModel.getMovieList()

        binding.movieListRecyclerView.let {
            it.layoutManager = GridLayoutManager(requireContext(), 2)
            it.adapter = MoviesAdapter(this)
        }

        movieListViewModel.movieListLiveData.observe(viewLifecycleOwner) {
            (binding.movieListRecyclerView.adapter as MoviesAdapter).setMovies(it)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        const val TAG = "movieList"
        fun newInstance(): MoviesListFragment = MoviesListFragment()
    }

    override fun onMovieClick(movie: Movie) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .add(
                R.id.main_container,
                MoviesDetailsFragment.newInstance(movie.id),
                MoviesDetailsFragment.TAG
            )
            .addToBackStack(MoviesDetailsFragment.TAG)
            .commit()
    }
}

