/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.presentation

import android.app.Application
import com.marvel.presentation.dependencyinjection.generalModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(generalModule)
        }
    }
}
