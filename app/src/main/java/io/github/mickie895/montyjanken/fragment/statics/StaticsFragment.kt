package io.github.mickie895.montyjanken.fragment.statics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.github.mickie895.montyjanken.R
import io.github.mickie895.montyjanken.databinding.FragmentStaticsBinding

@AndroidEntryPoint
class StaticsFragment : Fragment() {

    private val viewModel: StaticsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentStaticsBinding.inflate(inflater)
        viewModel.prepareStatics()
        val statics = viewModel.statics
        binding.countAll.text = statics.allCount.gameCount.toString()
        binding.countWin.text = statics.allCount.winCount.toString()
        binding.rateWin.text = getString(R.string.rate_format, statics.allCount.winRate)
        binding.countChanged.text = statics.handChangedCount.gameCount.toString()
        binding.countWinChanged.text = statics.handChangedCount.winCount.toString()
        binding.rateWinChanged.text = getString(R.string.rate_format, statics.handChangedCount.winRate)
        binding.countNotChange.text = statics.handNotChangedCount.gameCount.toString()
        binding.countWinNotChange.text = statics.handNotChangedCount.winCount.toString()
        binding.winRateNotChange.text = getString(R.string.rate_format, statics.handNotChangedCount.winRate)
        return binding.root
    }
}
