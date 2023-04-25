package io.github.mickie895.montyjanken.fragment.statics

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mickie895.montyjanken.model.GameSummaryRepository
import io.github.mickie895.montyjanken.model.statics.GameStatics
import javax.inject.Inject

@HiltViewModel
class StaticsViewModel @Inject constructor(private val gameSummaryRepository: GameSummaryRepository) : ViewModel() {

    private var capturedStatics: GameStatics? = null

    /**
     * 呼び出し時点での統計データを取得する
     */
    fun prepareStatics(): GameStatics {
        val statics = gameSummaryRepository.getStatics()
        capturedStatics = statics
        return statics
    }

    /**
     * 統計データの取得
     */
    val statics: GameStatics get() = capturedStatics ?: prepareStatics()
}
