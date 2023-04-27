package io.github.mickie895.montyjanken.fragment.statics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import io.github.mickie895.montyjanken.R
import io.github.mickie895.montyjanken.databinding.FragmentStaticsBinding
import io.github.mickie895.montyjanken.fragment.statics.dialogs.ClearHistoryDialog
import io.github.mickie895.montyjanken.fragment.statics.dialogs.CreateSampleConfirmDialog
import io.github.mickie895.montyjanken.model.statics.GameStatics

@AndroidEntryPoint
class StaticsFragment : Fragment() {

    private val viewModel: StaticsViewModel by viewModels()

    private lateinit var binding: FragmentStaticsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentStaticsBinding.inflate(inflater)
        binding.autoMatch.setOnClickListener(autoMatchClickListener)
        binding.clearHistory.setOnClickListener(clearHistoryClickListener)
        viewModel.statics.observe(this, staticsObserver)
        viewModel.prepareStatics()
        return binding.root
    }

    /**
     * ゲーム結果自動生成ボタンを押したときの処理
     */
    private val autoMatchClickListener = OnClickListener {
        val autoMatchConfirmDialog = CreateSampleConfirmDialog()
        autoMatchConfirmDialog.show(parentFragmentManager, null)
    }

    /**
     * 履歴クリアボタンを押したときの処理
     */
    private val clearHistoryClickListener = OnClickListener {
        val clearHistoryConfirmDialog = ClearHistoryDialog()
        clearHistoryConfirmDialog.show(parentFragmentManager, null)
    }

    /**
     * 統計データを受け取ったときに行う処理
     */
    private val staticsObserver = Observer<GameStatics> {
        binding.countAll.text = it.allCount.gameCount.toString()
        binding.countWin.text = it.allCount.winCount.toString()
        binding.rateWin.text = getString(R.string.rate_format, it.allCount.winRate)
        binding.countChanged.text = it.handChangedCount.gameCount.toString()
        binding.countWinChanged.text = it.handChangedCount.winCount.toString()
        binding.rateWinChanged.text = getString(R.string.rate_format, it.handChangedCount.winRate)
        binding.countNotChange.text = it.handNotChangedCount.gameCount.toString()
        binding.countWinNotChange.text = it.handNotChangedCount.winCount.toString()
        binding.winRateNotChange.text = getString(R.string.rate_format, it.handNotChangedCount.winRate)
    }
}
