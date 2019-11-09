/*
 * Copyright 2019 Two Buffers Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
