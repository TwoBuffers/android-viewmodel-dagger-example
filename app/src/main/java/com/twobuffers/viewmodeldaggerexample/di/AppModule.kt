@file:Suppress("unused")

package com.twobuffers.viewmodeldaggerexample.di

import android.app.Application
import com.twobuffers.base.di.ApplicationScoped
import com.twobuffers.viewmodeldaggerexample.App
import dagger.Binds
import dagger.Module

/**
 * Dagger module for the AppComponent
 */
@Module(includes = [
    BuildConfigModule::class,
    AppModule.BindingModule::class
])
class AppModule {

    @Module
    abstract class BindingModule {
        @Binds
        @ApplicationScoped
        abstract fun bindApplication(instance: App): Application
    }
}
