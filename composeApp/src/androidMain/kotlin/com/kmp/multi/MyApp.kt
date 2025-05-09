package com.kmp.multi

import android.app.Application
import di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

class MyApp : Application() {

    private val androidModules = module {

    }

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        initKoin(additionalModules = listOf(androidModules)) {
            androidContext(applicationContext)
        }
    }
}