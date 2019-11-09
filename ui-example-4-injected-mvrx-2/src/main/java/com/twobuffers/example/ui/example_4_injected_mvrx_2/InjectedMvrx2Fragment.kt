package com.twobuffers.example.ui.example_4_injected_mvrx_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.fragmentViewModel
import com.twobuffers.base.utils.Logger
import com.twobuffers.common.mvrx.BaseMviFragment
import com.twobuffers.example.ui.example_4_injected_mvrx_2.databinding.InjectedMvrx2FragmentBinding
import javax.inject.Inject

class InjectedMvrx2Fragment : BaseMviFragment<InjectedMvrx2Intent>() {

    @Inject lateinit var injectedMvrx2ViewModelFactory: InjectedMvrx2ViewModel.Factory
    private val viewModel: InjectedMvrx2ViewModel by fragmentViewModel()

    @Inject lateinit var logger: Logger

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        logger.i("onCreateView")
        val binding: InjectedMvrx2FragmentBinding = InjectedMvrx2FragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun invalidate() {
        logger.i("invalidate")
    }
}
