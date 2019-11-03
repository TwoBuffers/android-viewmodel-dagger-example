package com.twobuffers.example.ui.example_2_injected

import androidx.lifecycle.ViewModel
import com.twobuffers.example.utils.Logger
import javax.inject.Inject

class InjectedViewModel @Inject constructor(
    logger: Logger
) : ViewModel() {

    init {
        logger.d("init")
    }
}
