package io.github.mickie895.montyjanken.fragment.gamecycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.mickie895.montyjanken.R
import io.github.mickie895.montyjanken.databinding.FragmentResultShowBinding

@AndroidEntryPoint
class ResultShowFragment : Fragment() {

    private val viewModel: ResultShowViewModel by viewModels()

    private val changedString: String
        get() {
            return getString(
                when (viewModel.changed) {
                    true -> R.string.summary_change
                    false -> R.string.summary_nochange
                }
            )
        }

    private val summaryResultString: String
        get() {
            return getString(
                when (viewModel.hasWon) {
                    true -> R.string.summary_win
                    false -> R.string.summary_lose
                }
            )
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentResultShowBinding.inflate(inflater)
        binding.resultText.text = getString(
            when (viewModel.hasWon) {
                true -> R.string.result_win
                false -> R.string.result_lose
            }
        )
        binding.summaryText.text = getString(
            R.string.game_summary,
            handToString(viewModel.firstHand),
            changedString,
            summaryResultString,
            handToString(viewModel.opponentHand)
        )
        binding.nextGame.setOnClickListener {
            viewModel.resetGame()
            findNavController().navigate(R.id.action_resultShowFragment_to_firstHandSelectFragment)
        }
        return binding.root
    }
}