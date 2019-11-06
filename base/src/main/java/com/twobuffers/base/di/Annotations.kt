package com.twobuffers.base.di

import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Annotation for [Application] scoped objects.
 *
 * In Dagger, an unscoped component cannot depend on a scoped component. As
 * [AppComponent] is a scoped component (`@Singleton`, we create a custom scope
 * to be used by all activity components. Additionally, a component with
 * a specific scope cannot have a sub component with the same scope.
 */
@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScoped

// TODO: Consider moving ActivityScoped & FragmentScoped.
// Do we really need those in every layer? Maybe not. If so, move it.

/**
 * Annotation for [Activity] scoped objects.
 */
@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScoped

/**
 * Annotation for [Fragment] scoped objects.
 */
@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScoped

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class ProcessLifetime
