@file:Suppress("unused")

package com.twobuffers.common.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * This is the second file with annotations.
 * The first one is located in base module and contains non-Android annotations.
 * This one is going to contain annotations specific to view layer only.
 */

/**
 * Annotation for injecting <out ViewModel> objects.
 */
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
