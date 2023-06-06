package com.foodtracker.app.presentation.getstarted

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.foodtracker.app.R
import com.foodtracker.app.databinding.FragmentGetStartedBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GetStartedFragment : Fragment(R.layout.fragment_get_started) {

    private lateinit var binding: FragmentGetStartedBinding
    private val viewModel by activityViewModels<GetStartedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentGetStartedBinding.inflate(inflater, container, false)
        return binding.root
    }
}