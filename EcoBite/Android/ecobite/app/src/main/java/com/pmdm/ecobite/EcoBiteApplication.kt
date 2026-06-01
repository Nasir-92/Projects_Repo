package com.pmdm.ecobite

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LoginApplication: Application(){

    override fun onCreate(){

        super.onCreate()
        Log.d("App", "LoginApplication iniciada")
    }
}