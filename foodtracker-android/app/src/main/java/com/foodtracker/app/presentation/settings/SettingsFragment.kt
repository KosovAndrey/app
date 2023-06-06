package com.foodtracker.app.presentation.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.foodtracker.app.R
import com.foodtracker.app.databinding.FragmentSettingsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsFragment : Fragment() {

    //override val showBottomNavigationView = false
    private lateinit var binding: FragmentSettingsBinding
    private val viewModel by viewModel<SettingsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        binding.textView.setOnClickListener {
            viewModel.clearPreferences()
            findNavController().navigate(R.id.auth_nav_graph)
        }
        binding.buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }
}