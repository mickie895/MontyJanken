package io.github.mickie895.montyjanken.fragment.statics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mickie895.montyjanken.model.GameSummaryRepository
import io.github.mickie895.montyjanken.model.StaticsChangeReceiver
import io.github.mickie895.montyjanken.model.StaticsChangedNotify
import io.github.mickie895.montyjanken.model.statics.GameStatics
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StaticsViewModel @Inject constructor(
    private val gameSummaryRepository: GameSummaryRepository,
    staticsChangeReceiver: StaticsChangeReceiver,
) : ViewModel(), StaticsChangedNotify.StaticsChangedListener {

    private val staticsSource: MutableLiveData<GameStatics> = MutableLiveData()

    init {
        staticsChangeReceiver.setOnStaticsChangedListener(this)
    }

    /**
     * 統計データの取得
     */
    val statics: LiveData<GameStatics> get() = staticsSource

    /**
     * 呼び出し時点での統計データを取得する
     */
    fun prepareStatics() {
        viewModelScope.launch(Dispatchers.IO) {
            staticsSource.postValue(gameSummaryRepository.getStatics())
        }
    }

    /**
     * 統計データの変更があったときのイベント
     */
    override fun onStaticsChanged() {
        prepareStatics()
    }
}
