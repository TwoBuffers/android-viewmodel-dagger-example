package com.twobuffers.example.mvrx

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import com.airbnb.mvrx.BaseMvRxFragment
import com.twobuffers.example.mvi.MviIntent
import com.twobuffers.example.mvi.MviIntentsEmitter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch

abstract class BaseMviFragment<I : MviIntent> : BaseFragment, MviIntentsEmitter<I> {
    protected val intentsChannel: ConflatedBroadcastChannel<I> = ConflatedBroadcastChannel()

    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int = 0) : super(contentLayoutId)

    override fun intents(): Flow<I> = intentsChannel.asFlow()

    fun sendIntent(intent: I) = lifecycle.coroutineScope.launch {
        intentsChannel.send(intent)
    }
}

/**
 * BaseFragment
 */
abstract class BaseFragment : MyBaseMvRxDaggerFragment {
    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int = 0) : super(contentLayoutId)
}

/**
 * MyDaggerFragment - DaggerFragment with another constructor
 */
abstract class MyDaggerFragment : Fragment, HasAndroidInjector {
    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any>

    constructor() : super()

    constructor(@LayoutRes contentLayoutId: Int = 0) : super(contentLayoutId)

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}

/**
 * MyBaseMvRxDaggerFragment - merge of BaseMvRxDaggerFragment and MyDaggerFragment
 */
abstract class MyBaseMvRxDaggerFragment : BaseMvRxFragment, HasAndroidInjector {
    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any>

    constructor() : super()

    constructor(@LayoutRes contentLayoutId: Int = 0) : super(contentLayoutId)

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}
