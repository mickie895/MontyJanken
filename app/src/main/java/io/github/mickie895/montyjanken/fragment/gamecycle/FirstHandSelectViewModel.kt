package io.github.mickie895.montyjanken.fragment.gamecycle

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mickie895.montyjanken.model.GameCycle
import io.github.mickie895.montyjanken.model.GameCycleRepository
import io.github.mickie895.montyjanken.model.Hand
import javax.inject.Inject

@HiltViewModel
class FirstHandSelectViewModel @Inject constructor(private val gameCycleRepository: GameCycleRepository) :
    ViewModel() {

    private val gameCycle: GameCycle
        get() = gameCycleRepository.gameCycle

    init {
        // テストなどで間違っていることは予め確認しておくこと。
        if (gameCycle !is GameCycle.Start) {
            throw IllegalStateException("画面遷移に誤りがありそうです。現在の状態は${gameCycle}です。")
        }
    }

    fun gotoNextState(playerHand: Hand) {
        gameCycleRepository.proceed(playerHand)
    }
}