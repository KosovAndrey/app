package com.foodtracker.app.presentation.getstarted.currentWeight

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.foodtracker.app.R
import com.foodtracker.app.databinding.FragmentCurrentWeightBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CurrentWeightFragment : Fragment(R.layout.fragment_current_weight) {

    private val viewModel by viewModel<CurrentWeightViewModel>()
    private lateinit var binding: FragmentCurrentWeightBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCurrentWeightBinding.bind(view)
        binding.button.setOnClickListener {
            viewModel.setCurrentWeight(binding.currentWeightEditText.text.toString())
            findNavController().navigate(R.id.action_currentWeightFragment_to_goalWeightFragment)
        }
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}