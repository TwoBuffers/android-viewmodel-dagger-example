package com.twobuffers.example.ui.example_1_plain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PlainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.plain_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PlainFragment.newInstance())
                .commitNow()
        }
    }
}
