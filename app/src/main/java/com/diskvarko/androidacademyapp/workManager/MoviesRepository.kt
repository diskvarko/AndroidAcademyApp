package com.diskvarko.androidacademyapp.workManager

import androidx.work.*
import com.diskvarko.androidacademyapp.workManager.RefreshDataWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import java.util.concurrent.TimeUnit

class MoviesRepository {


    private val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresBatteryNotLow(true)
            .build()


    val repeatingRequest = PeriodicWorkRequestBuilder<RefreshDataWorker>(8L, TimeUnit.HOURS)
            .setConstraints(constraints)
            .build()

}
