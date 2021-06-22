package com.pvsb.nybooks.koin

import android.app.Application
import com.pvsb.nybooks.koin.modules.viewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(
                viewModel
            )

        }

    }

}