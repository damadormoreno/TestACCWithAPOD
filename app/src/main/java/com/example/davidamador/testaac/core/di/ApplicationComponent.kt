package com.example.davidamador.testaac.core.di

import com.example.davidamador.testaac.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: App)
}