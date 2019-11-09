package com.twobuffers.example.ui.example_4_injected_mvrx_2

import com.airbnb.mvrx.MvRxState

data class InjectedMvrx2State(
    val errorMessage: String? = null
) : MvRxState
