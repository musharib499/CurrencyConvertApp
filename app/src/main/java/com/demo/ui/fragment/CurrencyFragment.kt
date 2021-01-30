package com.demo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.demo.databinding.CurrencyFragmentBinding
import com.demo.ui.viewModule.CurrencyViewModule
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyFragment : Fragment() {

    companion object {
        fun newInstance() = CurrencyFragment()
    }

    private  val viewModel: CurrencyViewModule  by viewModels()
    private lateinit var binding: CurrencyFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CurrencyFragmentBinding.inflate(inflater, container, false).also {
            it.lifecycleOwner = this
            it.vm = viewModel

        }
        viewModel.loadData(viewLifecycleOwner)

        return binding.root
    }


}