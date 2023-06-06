package com.foodtracker.app.presentation.splash

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.foodtracker.app.R
import com.foodtracker.app.data.preferences.PreferenceStorage
import com.foodtracker.app.databinding.FragmentSplashBinding
import kotlinx.coroutines.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class SplashFragment : Fragment() {

    //    companion object {
//        private const val LOGO_TRANSITION_ANIMATION_DURATION = 500L
//        private const val TARGET_LOGO_VERTICAL_BIAS = 0.1f
//    }

    private lateinit var binding: FragmentSplashBinding
    //private lateinit var preference: PreferenceStorage
    private val viewModel by viewModel<SplashViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
//        preference = PreferenceStorage(this.requireContext())
        //val token = preference.accessToken

        CoroutineScope(Dispatchers.Main).launch {
            delay(2000L)
            if(viewModel.getToken().isNullOrEmpty()) {
                findNavController().navigate(R.id.action_splashFragment_to_auth_nav_graph)
            } else {
                findNavController().navigate(R.id.action_splashFragment_to_diary_nav_graph)
            }
        }
        return binding.root
    }
}