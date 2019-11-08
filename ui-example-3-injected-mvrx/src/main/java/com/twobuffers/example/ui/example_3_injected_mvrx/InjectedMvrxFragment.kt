package com.twobuffers.example.ui.example_3_injected_mvrx

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.fragmentViewModel
import com.twobuffers.base.utils.Logger
import com.twobuffers.common.mvrx.BaseMviFragment
import com.twobuffers.example.ui.example_3_injected_mvrx.databinding.InjectedmvrxFragmentBinding
import javax.inject.Inject

class InjectedMvrxFragment : BaseMviFragment<InjectedMvrxIntent>() {

    @Inject lateinit var injectedMvrxViewModelFactory: InjectedMvrxViewModel.Factory
    private val viewModel: InjectedMvrxViewModel by fragmentViewModel()

    @Inject lateinit var logger: Logger

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        logger.i("onCreateView")
        val binding: InjectedmvrxFragmentBinding = InjectedmvrxFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun invalidate() {
        logger.i("invalidate")
    }
}
