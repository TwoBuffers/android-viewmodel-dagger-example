package com.twobuffers.example.ui.example_4_injected_mvrx_2

import androidx.lifecycle.viewModelScope
import com.airbnb.mvrx.ActivityViewModelContext
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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Named

class InjectedMvrx2ViewModel @AssistedInject constructor(
    @Assisted initialState: InjectedMvrx2State,
    private val logger: Logger,
    @Named(TWOBUFFERS_DEBUG) debug: Boolean,
    dispatchers: AppCoroutineDispatchers
) : BaseMviViewModel<InjectedMvrx2State, InjectedMvrx2Intent>(initialState, debug),
    MviIntentsConsumer<InjectedMvrx2Intent> {

    private val localContext = viewModelScope + dispatchers.computation

    init {
        logger.d("init")
    }

    override fun processIntents(intents: Flow<InjectedMvrx2Intent>) = localContext.launch {
        intents.collect {
            when (it) {
                is InjectedMvrx2Intent.ScreenInitialising ->
                    logger.d("ScreenInitialising - NOT IMPLEMENTED")
                is InjectedMvrx2Intent.ErrorToastShown ->
                    logger.d("ErrorToastShown - NOT IMPLEMENTED")
            }
        }
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(initialState: InjectedMvrx2State): InjectedMvrx2ViewModel
    }

    companion object : MvRxViewModelFactory<InjectedMvrx2ViewModel, InjectedMvrx2State> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: InjectedMvrx2State
        ): InjectedMvrx2ViewModel? {
            return when (viewModelContext) {
                is ActivityViewModelContext -> viewModelContext.activity<InjectedMvrx2Activity>().injectedMvrx2ViewModelFactory
                is FragmentViewModelContext -> viewModelContext.fragment<InjectedMvrx2Fragment>().injectedMvrx2ViewModelFactory
            }.create(state)
        }
    }
}
