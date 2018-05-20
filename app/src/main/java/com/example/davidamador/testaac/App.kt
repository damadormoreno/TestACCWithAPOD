package com.example.davidamador.testaac

import android.app.Application
import com.example.davidamador.testaac.core.di.ApplicationComponent
import com.example.davidamador.testaac.core.di.ApplicationModule
import com.example.davidamador.testaac.core.di.DaggerApplicationComponent

class App : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
    }

    private fun injectMembers() = appComponent.inject(this)
}