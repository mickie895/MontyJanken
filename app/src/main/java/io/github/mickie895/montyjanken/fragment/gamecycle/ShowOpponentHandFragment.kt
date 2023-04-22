package io.github.mickie895.montyjanken.fragment.gamecycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.mickie895.montyjanken.R
import io.github.mickie895.montyjanken.databinding.FragmentShowOpponentHandBinding
import io.github.mickie895.montyjanken.fragment.views.OnHandSelectListener
import io.github.mickie895.montyjanken.model.Hand

@StringRes
fun handToResource(hand: Hand): Int = when (hand) {
    Hand.ROCK -> R.string.hand_rock
    Hand.SCISSOR -> R.string.hand_scissor
    Hand.PAPER -> R.string.hand_paper
}


@AndroidEntryPoint
class ShowOpponentHandFragment : Fragment(), OnHandSelectListener {

    private val showOpponentHandViewModel: ShowOpponentHandViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentShowOpponentHandBinding.inflate(inflater)
        binding.selectMatchHand.setForbiddenHand(showOpponentHandViewModel.playerCantUseHand)
        binding.textShowFirst.text = getString(
            R.string.check_selected,
            getString(handToResource(showOpponentHandViewModel.playerHand))
        )
        binding.textShowNotUseHand.text = getString(
            R.string.show_not_used_hand, getString(
                handToResource(showOpponentHandViewModel.opponentNotUseHand)
            )
        )
        return binding.root
    }

    override fun handSelected(hand: Hand) {
        showOpponentHandViewModel.proceed(hand)
        findNavController().navigate(R.id.action_showOpponentHandFragment_to_resultShowFragment)
    }
}