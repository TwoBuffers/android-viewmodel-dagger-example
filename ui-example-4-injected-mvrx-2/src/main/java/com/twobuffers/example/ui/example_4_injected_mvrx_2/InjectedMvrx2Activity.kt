package com.twobuffers.example.ui.example_4_injected_mvrx_2

import android.os.Bundle
import com.twobuffers.common.mvrx.BaseActivity
import javax.inject.Inject

class InjectedMvrx2Activity : BaseActivity() {
    @Inject lateinit var injectedMvrx2ViewModelFactory: InjectedMvrx2ViewModel.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.injected_mvrx2_activity)
    }
}
