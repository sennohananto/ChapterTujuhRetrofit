package com.binar.chaptertujuhretrofit

import android.app.Application
import com.binar.chaptertujuhretrofit.di.appModule
import org.koin.core.context.startKoin

class BaseApp : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}