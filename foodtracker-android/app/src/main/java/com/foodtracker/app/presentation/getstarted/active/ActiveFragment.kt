package com.foodtracker.app.presentation.getstarted.active

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.foodtracker.app.R
import com.foodtracker.app.databinding.FragmentActiveBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ActiveFragment : Fragment(R.layout.fragment_active) {

    private val viewModel by viewModel<ActiveViewModel>()
    private lateinit var binding: FragmentActiveBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentActiveBinding.bind(view)
        binding.lightlyActiveCardView.setOnClickListener {
            viewModel.setLightlyActive()
            findNavController().navigate(R.id.action_activeFragment_to_currentWeightFragment)
        }
        binding.moderatelyActiveCardView.setOnClickListener {
            viewModel.setModeratelyActive()
            findNavController().navigate(R.id.action_activeFragment_to_currentWeightFragment)
        }
        binding.activeActiveCardView.setOnClickListener {
            viewModel.setActiveActive()
            findNavController().navigate(R.id.action_activeFragment_to_currentWeightFragment)
        }
        binding.veryActiveCardView.setOnClickListener {
            viewModel.setVeryActive()
            findNavController().navigate(R.id.action_activeFragment_to_currentWeightFragment)
        }
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
