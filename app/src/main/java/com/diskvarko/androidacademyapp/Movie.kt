package com.diskvarko.androidacademyapp

data class Movie(
        val background: Int,
        val name: String,
        val tag: String,
        val ratingStars: Int,
        val reviews: Int,
        val time: Int,
        val pgRating: String,
        val isLiked: Boolean
) {

    companion object {
        fun getMoviesListData(): ArrayList<Movie> {
            val movies = ArrayList<Movie>()
            movies.apply {
                add(
                        Movie(
                                R.drawable.movie,
                                "Avengers:End Game",
                                "Action, Adventure, Fantasy",
                                4,
                                125,
                                137,
                                "13+",
                                isLiked = false

                        )
                )
                add(
                        Movie(
                                R.drawable.movie_2,
                                "Tenet",
                                "Action, Sci-Fi, Thriller ",
                                5,
                                98,
                                97,
                                "16+",
                                isLiked = false

                        )
                )
                add(
                        Movie(
                                R.drawable.movie_4,
                                "Black Widow",
                                "Action, Adventure, Sci-Fi",
                                4,
                                38,
                                102,
                                "13+",
                                isLiked = false

                        )
                )
                add(
                        Movie(
                                R.drawable.movie_3,
                                "Wonder Woman 1984",
                                "Action, Adventure, Fantasy",
                                5,
                                74,
                                120,
                                "13+",
                                isLiked = false

                        )
                )

            }
            return movies
        }
    }
}
