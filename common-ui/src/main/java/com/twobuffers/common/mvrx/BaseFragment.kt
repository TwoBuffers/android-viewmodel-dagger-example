package com.twobuffers.common.mvrx

import android.content.Context
import androidx.lifecycle.coroutineScope
import com.airbnb.mvrx.BaseMvRxFragment
import com.twobuffers.common.mvi.MviIntent
import com.twobuffers.common.mvi.MviIntentsEmitter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

abstract class BaseMviFragment<I : MviIntent> : BaseFragment(), MviIntentsEmitter<I> {
    protected val intentsChannel: ConflatedBroadcastChannel<I> = ConflatedBroadcastChannel()

    override fun intents(): Flow<I> = intentsChannel.asFlow()

    fun sendIntent(intent: I) = lifecycle.coroutineScope.launch {
        intentsChannel.send(intent)
    }
}

/**
 * BaseFragment
 */
abstract class BaseFragment : MyBaseMvRxDaggerFragment()

/**
 * MyBaseMvRxDaggerFragment - merge of BaseMvRxDaggerFragment and MyDaggerFragment
 */
abstract class MyBaseMvRxDaggerFragment : BaseMvRxFragment(), HasAndroidInjector {
    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}
