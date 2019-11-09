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

package com.twobuffers.example.ui.example_3_injected_mvrx

import androidx.lifecycle.viewModelScope
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.twobuffers.base.di.TWOBUFFERS_DEBUG
import com.twobuffers.base.utils.AppCoroutineDispatchers
import com.twobuffers.base.utils.Logger
import com.twobuffers.common.mvi.MviIntentsConsumer
import com.twobuffers.common.mvrx.BaseMviViewModel
import javax.inject.Named
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

class InjectedMvrxViewModel @AssistedInject constructor(
    @Assisted initialState: InjectedMvrxState,
    private val logger: Logger,
    @Named(TWOBUFFERS_DEBUG) debug: Boolean,
    dispatchers: AppCoroutineDispatchers
) : BaseMviViewModel<InjectedMvrxState, InjectedMvrxIntent>(initialState, debug),
    MviIntentsConsumer<InjectedMvrxIntent> {

    private val localContext = viewModelScope + dispatchers.computation

    init {
        logger.d("init")
    }

    override fun processIntents(intents: Flow<InjectedMvrxIntent>) = localContext.launch {
        intents.collect {
            when (it) {
                is InjectedMvrxIntent.ScreenInitialising ->
                    logger.d("ScreenInitialising - NOT IMPLEMENTED")
                is InjectedMvrxIntent.ErrorToastShown ->
                    logger.d("ErrorToastShown - NOT IMPLEMENTED")
            }
        }
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(initialState: InjectedMvrxState): InjectedMvrxViewModel
    }

    companion object : MvRxViewModelFactory<InjectedMvrxViewModel, InjectedMvrxState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: InjectedMvrxState
        ): InjectedMvrxViewModel? {
            val fragment: InjectedMvrxFragment =
                (viewModelContext as FragmentViewModelContext).fragment()
            return fragment.injectedMvrxViewModelFactory.create(state)
        }
    }
}
