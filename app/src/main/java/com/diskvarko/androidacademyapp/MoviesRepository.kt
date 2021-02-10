package com.diskvarko.androidacademyapp

import androidx.work.*
import com.diskvarko.androidacademyapp.workManager.RefreshDataWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import java.util.concurrent.TimeUnit

class MoviesRepository {


    val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .build()

    private val coroutineScope = CoroutineScope(Dispatchers.Default)


    val repeatingRequest = PeriodicWorkRequestBuilder<RefreshDataWorker>(15, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()

}
