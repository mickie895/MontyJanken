package io.github.mickie895.montyjanken.fragment.gamecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.mickie895.montyjanken.R
import io.github.mickie895.montyjanken.databinding.FragmentFirstHandSelectBinding
import io.github.mickie895.montyjanken.fragment.views.OnHandSelectListener
import io.github.mickie895.montyjanken.model.Hand

@AndroidEntryPoint
class FirstHandSelectFragment : Fragment(), OnHandSelectListener {

    private val viewModel: FirstHandSelectViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentFirstHandSelectBinding.inflate(inflater)
        binding.selectHand.setOnSelectedListener(this)
        return binding.root
    }

    override fun handSelected(hand: Hand) {
        viewModel.gotoNextState(hand)
        findNavController().navigate(R.id.action_firstHandSelectFragment_to_showOpponentHandFragment)
    }
}
