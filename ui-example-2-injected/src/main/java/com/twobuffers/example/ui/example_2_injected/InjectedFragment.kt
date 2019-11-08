package com.twobuffers.example.ui.example_2_injected

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.twobuffers.base.utils.Logger
import com.twobuffers.example.ui.example_2_injected.databinding.InjectedFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class InjectedFragment : DaggerFragment() {
    private lateinit var binding: InjectedFragmentBinding

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val activityViewModel: InjectedViewModel by activityViewModels { viewModelFactory }

    @Inject lateinit var logger: Logger

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        logger.i("onCreateView")
        binding = InjectedFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = activityViewModel
        return binding.root
    }
}
