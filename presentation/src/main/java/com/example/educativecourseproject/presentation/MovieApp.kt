package com.example.educativecourseproject.presentation

import android.app.Application
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MovieApp() : Application(), Configuration.Provider{
    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder().build()

}

