package com.diskvarko.androidacademyapp

data class Movie(
        val background: Int,
        val name: String,
        val tag: String,
        //val ratingStars: Int,
        val reviews: Int,
        val time: Int
        //val pgRating: String
) {
    companion object {
        fun getMoviesListData(): ArrayList<Movie> {
            val movies = ArrayList<Movie>()
            movies.apply {
                add(
                    Movie(
                            R.drawable.avengers_background,
                            "Avengers:End Game",
                            "Action, Adventure, Fantasy",

                            125,
                            137

                    )
                )
                            add (
                            Movie(
                                    R.drawable.avengers_background,
                                    "Tenet",
                                    "Action, Sci-Fi, Thriller ",

                                    98,
                                    97

                            )
                            )
                            add (
                            Movie(
                                    R.drawable.avengers_background,
                                    "Black Widow",
                                    "Action, Adventure, Sci-Fi",

                                    38,
                                    102

                            )
                            )
                            add (
                            Movie(
                                    R.drawable.avengers_background,
                                    "Wonder Woman 1984",
                                    "Action, Adventure, Fantasy",

                                    74,
                                    120

                            )
                            )

            }
            return movies
        }
    }
}
