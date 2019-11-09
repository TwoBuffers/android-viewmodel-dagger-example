@file:Suppress("unused")

package com.twobuffers.viewmodeldaggerexample.di

import com.twobuffers.base.di.TWOBUFFERS_DEBUG
import com.twobuffers.viewmodeldaggerexample.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class BuildConfigModule {
    @Provides
    @Named(TWOBUFFERS_DEBUG)
    fun provideIsDebug(): Boolean = BuildConfig.DEBUG
}
