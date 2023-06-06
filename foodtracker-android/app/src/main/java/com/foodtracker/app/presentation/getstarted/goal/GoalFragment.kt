package com.foodtracker.app.presentation.getstarted.goal

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.foodtracker.app.R
import com.foodtracker.app.databinding.FragmentGoalBinding

class GoalFragment : Fragment(R.layout.fragment_goal) {

    private lateinit var binding: FragmentGoalBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGoalBinding.bind(view)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_goalFragment_to_genderFragment)
        }
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}