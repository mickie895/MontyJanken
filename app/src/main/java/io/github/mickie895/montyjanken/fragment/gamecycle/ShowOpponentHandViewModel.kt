package io.github.mickie895.montyjanken.fragment.gamecycle

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mickie895.montyjanken.model.GameCycle
import io.github.mickie895.montyjanken.model.GameCycleRepository
import io.github.mickie895.montyjanken.model.GameState
import io.github.mickie895.montyjanken.model.Hand
import javax.inject.Inject

@HiltViewModel
class ShowOpponentHandViewModel @Inject constructor(private val gameCycleRepository: GameCycleRepository) : ViewModel() {
    private val gameState: GameState get() {
        when (val gameCycle = gameCycleRepository.gameCycle) {
            is GameCycle.HandSelected -> return gameCycle.gameState
            else -> throw IllegalStateException("画面遷移かDIコンテナに不備がありそうです")
        }
    }

    val playerHand get() = gameState.playerStartHand

    val opponentNotUseHand get() = gameState.opponentNotUseHand

    val playerCantUseHand get() = Hand.values().first{
        it.canWinTo(opponentNotUseHand)
    }

    fun proceed(hand: Hand){
        gameCycleRepository.proceed(hand)
    }
}