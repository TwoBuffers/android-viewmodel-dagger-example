package com.twobuffers.viewmodeldaggerexample

import com.twobuffers.common.appinitializers.AppInitializers
import com.twobuffers.viewmodeldaggerexample.di.createComponent
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
