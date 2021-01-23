package com.diskvarko.androidacademyapp.movieDetails

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.diskvarko.androidacademyapp.R
import com.diskvarko.androidacademyapp.data.Movie
import com.diskvarko.androidacademyapp.databinding.FragmentMoviesDetailsBinding
import com.diskvarko.androidacademyapp.movieList.MoviesInteractor
import com.diskvarko.androidacademyapp.network.Genre

class MoviesDetailsFragment : Fragment() {

    private var onBackButtonClickListener: MovieDetailsClickListener? = null

    private var binding: FragmentMoviesDetailsBinding? = null

    private val movieDetailsViewModel: MovieDetailsViewModel by viewModels() {
        MovieDetailsViewModelFactory(MoviesInteractor())
    }

    private var selectedMovieID: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_movies_details, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding = FragmentMoviesDetailsBinding.bind(view)
        binding!!.backButton.setOnClickListener { activity?.onBackPressed() }

        super.onViewCreated(view, savedInstanceState)

        movieDetailsViewModel.moviesLiveData.observe(
            this.viewLifecycleOwner,
            Observer { movieDetailsViewModel.getMovie() })
        if (savedInstanceState == null) {
            movieDetailsViewModel.setMovie(selectedMovieID)
        }

        movieDetailsViewModel.movie.observe(viewLifecycleOwner) { movie: Movie ->

            binding!!.background.load(movie.backdrop)
            binding!!.nameFilm.text = movie.title
            binding!!.ratingAge.text = "${movie.minimumAge} +"
            binding!!.descriptionStoryline.text = movie.overview
            binding!!.ratingBar.rating = setRating(movie.ratings.toFloat())
            binding!!.genre.text = setTags(movie.genres)
            binding!!.review.text = "${movie.numberOfRatings} REVIEWS"

            binding!!.actorList.apply {
                adapter = ActorsAdapter(movie.actors)
                layoutManager =
                    LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            }

            if (movie.actors.isNotEmpty()) {
                binding!!.actorList.visibility = View.VISIBLE

            } else binding!!.cast.visibility = View.INVISIBLE

            (binding!!.actorList.adapter as ActorsAdapter).updateActors(movie.actors)
        }


    }

    private fun setRating(rating10: Float): Float = rating10 / 2.0f

    private fun setTags(genres: List<Genre>): String = genres.joinToString(", ") { it.name }

    companion object {

        private const val MOVIE_ID = "movieId"
        const val TAG = "MovieDetailsFragment"

        fun newInstance(movieID: Long): MoviesDetailsFragment {
            val movieFragment = MoviesDetailsFragment()
            movieFragment.selectedMovieID = movieID.toInt()
            return movieFragment
        }

    }

    override fun onAttach(context: Context) {
        if (context is MovieDetailsClickListener) {
            onBackButtonClickListener = context
        }
        super.onAttach(context)
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    interface MovieDetailsClickListener {
        fun onBackButtonClicked()
    }
}






