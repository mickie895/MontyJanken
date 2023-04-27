package io.github.mickie895.montyjanken.fragment.statics.dialogs

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mickie895.montyjanken.model.GameSummaryRepository
import io.github.mickie895.montyjanken.model.StaticsChangeNotifySender
import javax.inject.Inject

@HiltViewModel
class ClearHistoryDialogViewModel @Inject constructor(
    private val gameSummaryRepository: GameSummaryRepository,
    private val staticsChangeNotifySender: StaticsChangeNotifySender
) : ViewModel() {
    fun clearHistory(){
        gameSummaryRepository.clearHistory()
        staticsChangeNotifySender.notifyStaticsChanged()
    }
}