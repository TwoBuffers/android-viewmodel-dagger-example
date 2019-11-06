package com.twobuffers.common.appinitializers

import android.app.Application
import com.twobuffers.base.di.TWOBUFFERS_DEBUG
import com.twobuffers.base.utils.AppInitializer
import com.twobuffers.base.utils.LoggerImpl
import javax.inject.Inject
import javax.inject.Named

class TimberInitializer @Inject constructor(
    @Named(TWOBUFFERS_DEBUG) private val isDebug: Boolean,
    private val logger: LoggerImpl
) : AppInitializer {
    override fun init(application: Application) = logger.setup(isDebug)
}
