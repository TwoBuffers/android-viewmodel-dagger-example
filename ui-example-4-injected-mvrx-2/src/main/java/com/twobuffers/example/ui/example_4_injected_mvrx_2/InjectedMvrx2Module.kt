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

package com.twobuffers.example.ui.example_4_injected_mvrx_2

import com.squareup.inject.assisted.dagger2.AssistedModule
import com.twobuffers.base.di.ActivityScoped
import com.twobuffers.base.di.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [
    InjectedMvrx2Module.ActivityDiModule::class
])
class InjectedMvrx2Module {

    @Module
    abstract class ActivityDiModule {
        @ContributesAndroidInjector(modules = [
            FragmentDiModule::class,
            ViewModelDiModule::class
        ])
        @ActivityScoped
        abstract fun contributeSubcomponent(): InjectedMvrx2Activity
    }

    @Module
    abstract class FragmentDiModule {
        @ContributesAndroidInjector(modules = [
            ViewModelDiModule::class
        ])
        @FragmentScoped
        abstract fun contributeSubcomponent(): InjectedMvrx2Fragment
    }

    @Module(includes = [InjectedMvrx2AssistedModule::class])
    abstract class ViewModelDiModule
}

@Module(includes = [AssistedInject_InjectedMvrx2AssistedModule::class])
@AssistedModule
interface InjectedMvrx2AssistedModule
