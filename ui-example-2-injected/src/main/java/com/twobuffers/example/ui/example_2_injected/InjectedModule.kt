@file:Suppress("unused")

package com.twobuffers.example.ui.example_2_injected

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.twobuffers.example.di.ActivityScoped
import com.twobuffers.example.di.FragmentScoped
import com.twobuffers.example.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Contains all modules related to Injected example, directly or indirectly.
 */
@Module(includes = [
    InjectedModule.InjectedActivitySubcomponentModule::class
])
class InjectedModule {

    @Module
    abstract class InjectedActivitySubcomponentModule {
        @ContributesAndroidInjector(modules = [
            InjectedFragmentSubcomponentModule::class,
            ViewModelBindingModule::class
        ])
        @ActivityScoped
        abstract fun contributeSubcomponent(): InjectedActivity

        @Binds
        @ActivityScoped
        abstract fun bindsFragmentActivity(activity: InjectedActivity): FragmentActivity
    }

    @Module
    abstract class InjectedFragmentSubcomponentModule {
        @ContributesAndroidInjector(modules = [])
        @FragmentScoped
        abstract fun contributeSubcomponent(): InjectedFragment
    }

    /** Necessary to instantiate InjectedViewModel. */
    @Module
    abstract class ViewModelBindingModule {
        @Binds
        @IntoMap
        @ViewModelKey(InjectedViewModel::class)
        abstract fun bindInjectedViewModel(viewModel: InjectedViewModel): ViewModel
    }
}
