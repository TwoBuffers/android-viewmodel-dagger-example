package com.chargedup.largestation.di

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

@Module(includes = [AssistedInject_AppAssistedModule::class])
@AssistedModule
interface AppAssistedModule
