package com.twobuffers.example.appinitializers

import android.app.Application

interface AppInitializer {
    fun init(application: Application)
}
