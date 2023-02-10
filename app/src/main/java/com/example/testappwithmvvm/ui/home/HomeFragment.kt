package com.example.testappwithmvvm.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.testappwithmvvm.R
import com.example.testappwithmvvm.data.network.Resource
import com.example.testappwithmvvm.data.response.User
import com.example.testappwithmvvm.databinding.FragmentHomeBinding
import com.example.testappwithmvvm.ui.handleApiError
import com.example.testappwithmvvm.ui.logout
import com.example.testappwithmvvm.ui.visible

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        binding.progressbar.visible(false)

        viewModel.getUser()

        viewModel.user.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    binding.progressbar.visible(false)
                    updateUI(it.value.user)
                }
                is Resource.Loading -> {
                    binding.progressbar.visible(true)
                }
                is Resource.Failure -> {
                    handleApiError(it)
                }
            }
        })

        binding.buttonLogout.setOnClickListener {
            logout()
        }
    }

    private fun updateUI(user: User) {
        with(binding) {
           // textViewId.text = user..toString()
           // textViewName.text = user.name
           // textViewEmail.text = user.email
        }
    }
}