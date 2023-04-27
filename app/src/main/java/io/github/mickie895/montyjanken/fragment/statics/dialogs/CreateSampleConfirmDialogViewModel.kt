package io.github.mickie895.montyjanken.fragment.statics.dialogs

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mickie895.montyjanken.model.GameSummaryRepository
import io.github.mickie895.montyjanken.model.SampleGame
import io.github.mickie895.montyjanken.model.StaticsChangeNotifySender
import javax.inject.Inject

@HiltViewModel
class CreateSampleConfirmDialogViewModel @Inject constructor(private val gameSummaryRepository: GameSummaryRepository, private val staticsChangeNotifySender: StaticsChangeNotifySender) : ViewModel() {
    fun createSample(count: Int) {
        for (i in 1..count) {
            gameSummaryRepository.addToHistory(SampleGame.sampleHandChange())
            gameSummaryRepository.addToHistory(SampleGame.sampleHandNotChange())
        }
        staticsChangeNotifySender.notifyStaticsChanged()
    }
}
