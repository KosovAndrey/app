package com.foodtracker.app.presentation.getstarted.height

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.foodtracker.app.R
import com.foodtracker.app.databinding.FragmentHeightBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeightFragment : Fragment(R.layout.fragment_height) {

    private val viewModel by viewModel<HeightViewModel>()
    private lateinit var binding: FragmentHeightBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHeightBinding.bind(view)
        binding.button.setOnClickListener {
            viewModel.setHeight(height = binding.heightEditText.text.toString())
            findNavController().navigate(R.id.action_heightFragment_to_activeFragment)
        }
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}