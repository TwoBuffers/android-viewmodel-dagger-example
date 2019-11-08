package com.twobuffers.example.ui.example_3_injected_mvrx

import com.airbnb.mvrx.MvRxState

data class InjectedMvrxState(
    val errorMessage: String? = null
) : MvRxState
