package com.twobuffers.example.ui.example_3_injected_mvrx

import com.twobuffers.common.mvi.MviIntent

sealed class InjectedMvrxIntent : MviIntent {
    object ScreenInitialising : InjectedMvrxIntent()
    object ErrorToastShown : InjectedMvrxIntent()
}
