package io.github.mickie895.montyjanken.fragment.menuscreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.InflateException
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import io.github.mickie895.montyjanken.R
import io.github.mickie895.montyjanken.databinding.FragmentMainMenuBinding

class MainMenuFragment : Fragment() {

    companion object {
        fun newInstance() = MainMenuFragment()
    }

    private val viewModel: MainMenuViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainMenuBinding.inflate(layoutInflater)
        binding.startMainButton.setOnClickListener{
            findNavController().navigate(R.id.action_mainMenuFragment_to_firstHandSelectFragment)
        }
        return binding.root
    }

}