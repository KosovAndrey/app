package com.foodtracker.app.presentation.getstarted.name

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.foodtracker.app.R
import com.foodtracker.app.databinding.FragmentNameBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class NameFragment : Fragment(R.layout.fragment_name) {

    private lateinit var binding: FragmentNameBinding
    private val viewModel by viewModel<NameViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNameBinding.bind(view)
        binding.button.setOnClickListener {
            viewModel.setName(binding.nameEditText.text.toString())
            findNavController().navigate(R.id.action_nameFragment_to_goalFragment)
        }
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

    }
}