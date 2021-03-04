package com.diskvarko.androidacademyapp.workManager

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.diskvarko.androidacademyapp.MoviesInteractor
import com.diskvarko.androidacademyapp.data.getMoviesList
import com.diskvarko.androidacademyapp.movieList.LOG_TAG
import com.diskvarko.androidacademyapp.room.MoviesDB.Companion.getDatabase
import kotlinx.serialization.ExperimentalSerializationApi
import retrofit2.HttpException

class RefreshDataWorker(appContext: Context, workerParams: WorkerParameters) : CoroutineWorker(appContext, workerParams) {

    private val repository = MoviesInteractor(getDatabase(appContext).movieDao())

    companion object {
        const val WORK_NAME = "com.diskvarko.androidacademyapp.RefreshDataWorker"
    }

    @ExperimentalSerializationApi
    override suspend fun doWork(): Result {

        return try {
            Log.d(LOG_TAG, "Work request for sync is run")
            val movies = getMoviesList()
            repository.addMovies(movies)
            Result.success()
        }
        catch (e: HttpException) {
            Log.d(LOG_TAG, "Exception")
            Result.retry()
        }


    }
}