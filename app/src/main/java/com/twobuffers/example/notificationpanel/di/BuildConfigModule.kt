@file:Suppress("unused")

package com.twobuffers.example.notificationpanel.di

import com.twobuffers.example.di.TWOBUFFERS_DEBUG
import com.twobuffers.example.notificationpanel.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class BuildConfigModule {
    @Provides
    @Named(TWOBUFFERS_DEBUG)
    fun provideIsDebug(): Boolean = BuildConfig.DEBUG
}
