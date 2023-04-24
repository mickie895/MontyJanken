package io.github.mickie895.montyjanken.fragment.menuscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.mickie895.montyjanken.R
import io.github.mickie895.montyjanken.databinding.FragmentMainMenuBinding

@AndroidEntryPoint
class MainMenuFragment : Fragment() {

    private val viewModel: MainMenuViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentMainMenuBinding.inflate(layoutInflater)
        binding.startMainButton.setOnClickListener {
            viewModel.startGame()
            findNavController().navigate(R.id.action_mainMenuFragment_to_firstHandSelectFragment)
        }
        return binding.root
    }
}
