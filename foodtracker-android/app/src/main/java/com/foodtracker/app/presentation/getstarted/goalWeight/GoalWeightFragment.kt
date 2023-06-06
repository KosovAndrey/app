package com.foodtracker.app.presentation.getstarted.goalWeight

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.foodtracker.app.R
import com.foodtracker.app.databinding.FragmentGoalWeightBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GoalWeightFragment : Fragment(R.layout.fragment_goal_weight) {

    private val viewModel by viewModel<GoalWeightViewModel>()
    private lateinit var binding: FragmentGoalWeightBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGoalWeightBinding.bind(view)
        binding.goalWeightEditText.hint =
            (viewModel.getCurrentWeight()?.toInt()?.minus(5) ?: 50).toString()
        binding.button.setOnClickListener {
            viewModel.setGoalWeight(binding.goalWeightEditText.text.toString())
            findNavController().navigate(R.id.registerFragment)
        }
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}