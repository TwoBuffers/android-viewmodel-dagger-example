@file:Suppress("unused")

package com.twobuffers.example.notificationpanel.di

import android.app.Application
import com.twobuffers.example.di.ApplicationScoped
import com.twobuffers.example.notificationpanel.App
import com.twobuffers.example.ui.example_2_injected.InjectedModule
import dagger.Binds
import dagger.Module

/**
 * Dagger module for the AppComponent
 */
@Module(includes = [
    BuildConfigModule::class,
    AppCommonModule::class,
    InjectedModule::class,
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
