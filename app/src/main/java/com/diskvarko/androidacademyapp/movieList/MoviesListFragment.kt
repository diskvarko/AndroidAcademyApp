package com.diskvarko.androidacademyapp.movieList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.WorkManager
import com.diskvarko.androidacademyapp.MoviesInteractor
import com.diskvarko.androidacademyapp.R
import com.diskvarko.androidacademyapp.data.Movie
import com.diskvarko.androidacademyapp.data.getMoviesList
import com.diskvarko.androidacademyapp.databinding.FragmentMoviesListBinding
import com.diskvarko.androidacademyapp.movieDetails.MoviesDetailsFragment
import com.diskvarko.androidacademyapp.room.getDatabase
import com.diskvarko.androidacademyapp.MoviesRepository
import com.diskvarko.androidacademyapp.workManager.RefreshDataWorker.Companion.WORK_NAME
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val LOG_TAG = "DBCREATION"

class MoviesListFragment() : Fragment(), MoviesAdapter.OnMovieClickListener {

    private val repository: MoviesInteractor by lazy {
        val db = getDatabase(this.requireContext().applicationContext)
        MoviesInteractor(db.movieDao())
    }

    private val movieListViewModel: MoviesViewModel by viewModels()
    {
        MovieListViewModelFactory(repository)
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

        CoroutineScope(Dispatchers.IO).launch {
            val movies = getMoviesList()
            Log.d(LOG_TAG, "$movies")
            Log.d(LOG_TAG, "onViewCreated: movies count ${movies.size}")
        }

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

