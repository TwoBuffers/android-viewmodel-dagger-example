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

package com.twobuffers.common.mvrx

import android.content.Context
import androidx.lifecycle.coroutineScope
import com.airbnb.mvrx.BaseMvRxFragment
import com.twobuffers.common.mvi.MviIntent
import com.twobuffers.common.mvi.MviIntentsEmitter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch

abstract class BaseMviFragment<I : MviIntent> : BaseFragment(), MviIntentsEmitter<I> {
    protected val intentsChannel: ConflatedBroadcastChannel<I> = ConflatedBroadcastChannel()

    override fun intents(): Flow<I> = intentsChannel.asFlow()

    fun sendIntent(intent: I) = lifecycle.coroutineScope.launch {
        intentsChannel.send(intent)
    }
}

/**
 * BaseFragment
 */
abstract class BaseFragment : MyBaseMvRxDaggerFragment()

/**
 * MyBaseMvRxDaggerFragment - merge of BaseMvRxDaggerFragment and MyDaggerFragment
 */
abstract class MyBaseMvRxDaggerFragment : BaseMvRxFragment(), HasAndroidInjector {
    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}
