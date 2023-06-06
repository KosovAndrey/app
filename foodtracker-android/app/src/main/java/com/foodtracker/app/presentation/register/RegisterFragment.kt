package com.foodtracker.app.presentation.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.foodtracker.app.R
import com.foodtracker.app.databinding.FragmentRegisterBinding
import com.foodtracker.app.domain.model.UserCreate
import com.foodtracker.app.presentation.ValidationTextInput
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding: FragmentRegisterBinding
    private val validator = ValidationTextInput()
    private val bundle = Bundle()
    private lateinit var userCreate: UserCreate
    private val viewModel by viewModel<RegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        with(binding) {
            buttonRegister.setOnClickListener {
                emailInputLayout.error = validator.validateEmail(emailTextInput.text)
                passwordInputLayout.error = validator.validatePassword(passwordTextInput.text)
                confirmedPasswordInputLayout.error =
                    validator.confirmPassword(confirmedPasswordTextInput.text,
                        passwordTextInput.text)
                if (emailInputLayout.error == null &&
                    passwordInputLayout.error == null &&
                    confirmedPasswordInputLayout.error == null
                ) {
//                    userCreate = UserCreate(
//                        username = viewModel.getName(),
//                        email = emailTextInput.text.toString(),
//                        password = passwordTextInput.text.toString(),
//                        gender = viewModel.gender,
//                        birthdate = viewModel.birthdate,
//                        active = viewModel.active,
//                        goalWeight = viewModel.goalWeight,
//                        currentWeight = viewModel.currentWeight,
//                        height = viewModel.height
//                    )
//                    viewModel.registrationUser(userCreate)
                    val email = emailTextInput.text.toString()
                    val password = passwordTextInput.text.toString()
                    viewModel.registrationUser(email = email, password = password)
                }
            }
        }
        viewModel.token.observe(viewLifecycleOwner) { tokenResult ->
            if (tokenResult != null) {
                viewModel.setEmail(userCreate.email)
                findNavController().navigate(
                    R.id.diary_nav_graph,
                    bundle
                )
            } else {
                Toast.makeText(context, "не успешно", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}