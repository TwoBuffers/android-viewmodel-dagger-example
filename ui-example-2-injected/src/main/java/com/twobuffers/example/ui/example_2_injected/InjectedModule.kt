@file:Suppress("unused")

package com.twobuffers.example.ui.example_2_injected

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.twobuffers.base.di.ActivityScoped
import com.twobuffers.base.di.FragmentScoped
import com.twobuffers.common.di.ViewModelFactory
import com.twobuffers.common.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(includes = [
    InjectedModule.ActivityDiModule::class
])
class InjectedModule {

    @Module
    abstract class ActivityDiModule {
        @ContributesAndroidInjector(modules = [
            FragmentDiModule::class
        ])
        @ActivityScoped
        abstract fun contributeSubcomponent(): InjectedActivity

        @Binds
        @ActivityScoped
        abstract fun bindsFragmentActivity(activity: InjectedActivity): FragmentActivity
    }

    @Module
    abstract class FragmentDiModule {
        @ContributesAndroidInjector(modules = [
            ViewModelDiModule::class
        ])
        @FragmentScoped
        abstract fun contributeSubcomponent(): InjectedFragment
    }

    /** Necessary to instantiate InjectedViewModel. */
    @Module(includes = [ViewModelFactory.Builder::class])
    abstract class ViewModelDiModule {
        @Binds
        @IntoMap
        @ViewModelKey(InjectedViewModel::class)
        abstract fun bindInjectedViewModel(viewModel: InjectedViewModel): ViewModel
    }
}
