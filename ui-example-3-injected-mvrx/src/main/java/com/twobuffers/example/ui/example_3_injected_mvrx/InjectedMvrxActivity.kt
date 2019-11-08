package com.twobuffers.example.ui.example_3_injected_mvrx

import android.os.Bundle
import com.twobuffers.common.mvrx.BaseActivity

class InjectedMvrxActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.injected_mvrx_activity)
    }
}
