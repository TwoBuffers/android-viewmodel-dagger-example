package com.twobuffers.example.mvi

import io.reactivex.Observable
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow

/**
 * Immutable object which represent a view's intent.
 */
interface MviIntent

/**
 * Intents' emitter and consumer - Flow variant
 */
interface MviIntentsEmitter<I : MviIntent> {
    fun intents(): Flow<I>
}

interface MviIntentsConsumer<I : MviIntent> {
    fun processIntents(intents: Flow<I>): Job
}

/**
 * Intents' emitter and consumer - RxJava variant
 */
interface MviIntentsEmitterRx<I : MviIntent> {
    fun intents(): Observable<I>
}

interface MviIntentsConsumerRx<I : MviIntent> {
    fun processIntents(intents: Observable<I>)
}
