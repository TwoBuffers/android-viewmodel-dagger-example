package com.twobuffers.example.appinitializers

import android.app.Application
import com.twobuffers.example.di.TWOBUFFERS_DEBUG
import com.twobuffers.example.utils.LoggerImpl
import javax.inject.Inject
import javax.inject.Named

class TimberInitializer @Inject constructor(
    @Named(TWOBUFFERS_DEBUG) private val isDebug: Boolean,
    private val logger: LoggerImpl
) : AppInitializer {
    override fun init(application: Application) = logger.setup(isDebug)
}
