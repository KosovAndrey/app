package com.foodtracker.app.presentation.login

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.foodtracker.app.R
import com.foodtracker.app.databinding.FragmentLoginBinding
import com.foodtracker.app.domain.model.UserCreate
import com.foodtracker.app.domain.model.UserLogin
import com.foodtracker.app.presentation.ValidationTextInput
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var userCreate: UserCreate
    private lateinit var binding: FragmentLoginBinding
    private lateinit var userLogin: UserLogin
    private val bundle = Bundle()
    private val viewModel by viewModel<LoginViewModel>()
    private val validator = ValidationTextInput()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        with(binding) {
    //            buttonLogin.setOnClickListener {
    //                performLogin()
    //                //findNavController().navigate(R.id.diary_nav_graph)
    //            }


            textViewRegister.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_get_started_nav_graph)
            }

            buttonLogin.setOnClickListener {
                emailInputLayout.error = validator.validateEmail(emailTextInput.text)
                passwordInputLayout.error = validator.validatePassword(passwordTextInput.text)
                if (emailInputLayout.error == passwordInputLayout.error) {
                    userLogin = UserLogin(
                        email = emailTextInput.text.toString(),
                        password = passwordTextInput.text.toString()
                    )
                    viewModel.login(userLogin)
                }
            }
        }
        viewModel.token.observe(viewLifecycleOwner) { tokenResult ->
            if (tokenResult != null) {
                viewModel.setEmail(userLogin.email)
                findNavController().navigate(R.id.diary_nav_graph, bundle)
                Toast.makeText(context, getString(R.string.success), Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(context, getString(R.string.not_success), Toast.LENGTH_SHORT)
                    .show()
            }
        }
        return binding.root
    }


    private fun performLogin() = with(binding) {
        activity?.hideSoftKeyboard()
        emailInputLayout.error = validator.validateEmail(emailTextInput.text)
        passwordInputLayout.error = validator.validatePassword(passwordTextInput.text)
        val email = emailTextInput.text.toString()
        val password = passwordTextInput.text.toString()
        val userLogin = UserLogin(
            email = email,
            password = password
        )
        if (emailInputLayout.error == null && passwordInputLayout.error == null) {
            viewModel.login(userLogin = userLogin)
            findNavController().navigate(R.id.diary_nav_graph)
        } else {
            Toast.makeText(requireContext(), "User doesn't exist", Toast.LENGTH_SHORT)
        }
    }

    fun Activity.hideSoftKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }


}