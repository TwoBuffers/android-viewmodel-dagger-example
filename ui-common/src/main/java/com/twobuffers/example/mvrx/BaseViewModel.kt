package com.twobuffers.example.mvrx

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.twobuffers.example.mvi.MviIntent
import com.twobuffers.example.mvi.MviIntentsConsumer

abstract class BaseMviViewModel<S : MvRxState, I : MviIntent>(initialState: S, debugMode: Boolean) :
    BaseViewModel<S>(initialState, debugMode = debugMode), MviIntentsConsumer<I>

abstract class BaseViewModel<S : MvRxState>(initialState: S, debugMode: Boolean) :
    BaseMvRxViewModel<S>(initialState, debugMode = debugMode)
