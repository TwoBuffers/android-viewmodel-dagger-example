package com.twobuffers.example.ui.example_2_injected

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

class InjectedActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.injected_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, InjectedFragment.newInstance())
                .commitNow()
        }
    }
}
