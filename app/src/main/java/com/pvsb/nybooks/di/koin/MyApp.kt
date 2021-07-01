package com.pvsb.nybooks.di.koin

import android.app.Application
import com.pvsb.nybooks.di.koin.modules.networkModule
import com.pvsb.nybooks.di.koin.modules.repositoryModule
import com.pvsb.nybooks.di.koin.modules.viewModelModule
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
                viewModelModule,
                repositoryModule,
                networkModule
            )
        }
    }
}

