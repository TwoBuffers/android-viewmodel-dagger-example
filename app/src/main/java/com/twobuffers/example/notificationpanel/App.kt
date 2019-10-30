package com.twobuffers.example.notificationpanel

import com.twobuffers.example.appinitializers.AppInitializers
import com.twobuffers.example.notificationpanel.di.createComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class App : DaggerApplication() {
    @Inject lateinit var initializers: AppInitializers

    override fun onCreate() {
        super.onCreate()
        initializers.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = createComponent()
}
