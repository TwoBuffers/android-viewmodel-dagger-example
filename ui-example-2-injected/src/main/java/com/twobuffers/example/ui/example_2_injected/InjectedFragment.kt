package com.twobuffers.example.ui.example_2_injected

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.twobuffers.base.utils.Logger
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class InjectedFragment : DaggerFragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val activityViewModel: InjectedViewModel by activityViewModels { viewModelFactory }

    @Inject lateinit var logger: Logger

    companion object {
        fun newInstance() = InjectedFragment()
    }

    private lateinit var viewModel: InjectedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        logger.i("onCreateView")
        return inflater.inflate(R.layout.injected_fragment, container, false)
    }
}
