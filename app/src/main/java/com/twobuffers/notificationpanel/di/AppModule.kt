@file:Suppress("unused")

package com.twobuffers.notificationpanel.di

import android.app.Application
import com.twobuffers.base.di.ApplicationScoped
import com.twobuffers.common.di.AppCommonModule
import com.twobuffers.example.ui.example_2_injected.InjectedModule
import com.twobuffers.notificationpanel.App
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
