package com.twobuffers.common.appinitializers

import android.app.Application

interface AppInitializer {
    fun init(application: Application)
}
