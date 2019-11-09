package com.twobuffers.notificationpanel.di

import com.twobuffers.base.di.ApplicationScoped
import com.twobuffers.common.di.AppCommonModule
import com.twobuffers.example.ui.example_2_injected.InjectedModule
import com.twobuffers.example.ui.example_3_injected_mvrx.InjectedMvrxModule
import com.twobuffers.example.ui.example_4_injected_mvrx_2.InjectedMvrx2Module
import com.twobuffers.notificationpanel.App
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
    AppCommonModule::class,
    InjectedModule::class,
    InjectedMvrxModule::class,
    InjectedMvrx2Module::class,
    AndroidInjectionModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: App): AppComponent
    }
}

fun App.createComponent() = DaggerAppComponent.factory().create(this)
