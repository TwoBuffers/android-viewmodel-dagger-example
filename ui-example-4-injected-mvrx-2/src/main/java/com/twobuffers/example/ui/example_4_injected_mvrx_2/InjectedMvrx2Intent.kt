package com.twobuffers.example.ui.example_4_injected_mvrx_2

import com.twobuffers.common.mvi.MviIntent

sealed class InjectedMvrx2Intent : MviIntent {
    object ScreenInitialising : InjectedMvrx2Intent()
    object ErrorToastShown : InjectedMvrx2Intent()
}
