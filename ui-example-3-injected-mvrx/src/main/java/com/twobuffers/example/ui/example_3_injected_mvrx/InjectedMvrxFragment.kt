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
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        logger.i("onCreateView")
        val binding = InjectedmvrxFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun invalidate() {
        logger.i("invalidate")
    }
}
