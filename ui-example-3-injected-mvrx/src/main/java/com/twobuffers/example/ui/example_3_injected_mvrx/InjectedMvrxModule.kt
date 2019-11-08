@file:Suppress("unused")

package com.twobuffers.example.ui.example_3_injected_mvrx

import com.squareup.inject.assisted.dagger2.AssistedModule
import com.twobuffers.base.di.ActivityScoped
import com.twobuffers.base.di.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [
    InjectedMvrxModule.ActivityDiModule::class
])
class InjectedMvrxModule {

    @Module
    abstract class ActivityDiModule {
        @ContributesAndroidInjector(modules = [
            FragmentDiModule::class
        ])
        @ActivityScoped
        abstract fun contributeSubcomponent(): InjectedMvrxActivity
    }

    @Module
    abstract class FragmentDiModule {
        @ContributesAndroidInjector(modules = [
            ViewModelDiModule::class
        ])
        @FragmentScoped
        abstract fun contributeSubcomponent(): InjectedMvrxFragment
    }

    @Module(includes = [InjectedMvrxAssistedModule::class])
    abstract class ViewModelDiModule
}

@Module(includes = [AssistedInject_InjectedMvrxAssistedModule::class])
@AssistedModule
interface InjectedMvrxAssistedModule
