package com.diskvarko.androidacademyapp.data

import com.diskvarko.androidacademyapp.network.Configuration
import com.diskvarko.androidacademyapp.network.Genre
import com.diskvarko.androidacademyapp.network.Movies
import com.diskvarko.androidacademyapp.network.Retrofit.movieApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi


@ExperimentalSerializationApi
private suspend fun getConfiguration(): Configuration = movieApi.getConfiguration()

@ExperimentalSerializationApi
private suspend fun getMovies(): Movies = movieApi.getMovies()

@ExperimentalSerializationApi
private suspend fun getGenres(): Map<Int, Genre> =
    movieApi.getGenres().genres.map { it.id to it }.toMap()

@ExperimentalSerializationApi
private suspend fun getActors(movieId: Long): List<Actor> {
    return movieApi.getCredits(movieId).cast
        .map { Actor(it.castID ?: 0, it.profilePath ?: "", it.name) }
        .toList()
}

@ExperimentalSerializationApi
private suspend fun getRuntime(movieId: Long): Int = movieApi.getDetails(movieId).runtime

@ExperimentalSerializationApi
suspend fun getMoviesList(): List<Movie> = withContext(Dispatchers.IO) {
    val imagesBaseUrl = getConfiguration().images.secureBaseURL.dropLast(1)

    val genres: Map<Int, Genre> = getGenres()

    return@withContext getMovies().results.map {
        Movie(
            id = it.id,
            title = it.title,
            overview = it.overview,
            poster = "$imagesBaseUrl/original/${it.posterPath}",
            backdrop = "$imagesBaseUrl/original/${it.backdropPath}",
            ratings = it.voteAverage.toFloat(),
            numberOfRatings = it.voteCount,
            minimumAge = if (it.adult) 16 else 13,
            runtime = getRuntime(it.id),
            genres = it.genreIDS.map { id -> genres.getOrDefault(id.toInt(), Genre(0, "")) }.toList(),
            actors = getActors(it.id).map { actor -> actor.copy(picture = "$imagesBaseUrl/original/${actor.picture}") }
        )
    }
}