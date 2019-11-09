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

package com.twobuffers.viewmodeldaggerexample.di

import com.twobuffers.base.di.ApplicationScoped
import com.twobuffers.common.di.AppCommonModule
import com.twobuffers.example.ui.example_2_injected.InjectedModule
import com.twobuffers.example.ui.example_3_injected_mvrx.InjectedMvrxModule
import com.twobuffers.example.ui.example_4_injected_mvrx_2.InjectedMvrx2Module
import com.twobuffers.viewmodeldaggerexample.App
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
