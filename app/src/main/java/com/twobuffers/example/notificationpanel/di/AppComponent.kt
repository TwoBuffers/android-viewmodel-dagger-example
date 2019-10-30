package com.twobuffers.example.notificationpanel.di

import com.twobuffers.example.di.ApplicationScoped
import com.twobuffers.example.notificationpanel.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector

/**
 * The root Dagger component referring to [App].
 *
 * Even though Dagger allows annotating a [Component] as a singleton, the code
 * itself must ensure only one instance of the class is created.
 * This is done in [App] (by creating [DaggerAppComponent] only once).
 *
 * [AndroidInjectionModule] is a module from Dagger.Android that helps
 * with the generation and location of subcomponents created by @[ContributesAndroidInjector]
 */
@ApplicationScoped
@Component(modules = [
    AppModule::class,
    AndroidInjectionModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: App): AppComponent
    }
}

fun App.createComponent() = DaggerAppComponent.factory().create(this)
