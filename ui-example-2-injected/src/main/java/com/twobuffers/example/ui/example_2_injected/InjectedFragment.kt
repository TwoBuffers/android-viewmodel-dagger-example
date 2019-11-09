/*
 * Copyright 2019 Two Buffers Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        logger.i("onCreateView")
        binding = InjectedFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = activityViewModel
        return binding.root
    }
}
