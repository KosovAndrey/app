package com.foodtracker.app.presentation.getstarted.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.foodtracker.app.R
import com.foodtracker.app.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding: FragmentRegisterBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)
        binding.buttonRegister.setOnClickListener {

        }
    }
}