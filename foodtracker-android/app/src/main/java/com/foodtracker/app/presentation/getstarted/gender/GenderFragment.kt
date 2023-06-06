package com.foodtracker.app.presentation.getstarted.gender

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.foodtracker.app.R
import com.foodtracker.app.databinding.FragmentGenderBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GenderFragment : Fragment(R.layout.fragment_gender) {

    private val viewModel by viewModel<GenderViewModel>()
    private lateinit var binding: FragmentGenderBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGenderBinding.bind(view)
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.femaleCardView.setOnClickListener {
            viewModel.setFemaleGender()
            findNavController().navigate(R.id.action_genderFragment_to_birthdayFragment)
        }
        binding.maleCardView.setOnClickListener {
            viewModel.setMaleGender()
            findNavController().navigate(R.id.action_genderFragment_to_birthdayFragment)
        }
    }
}