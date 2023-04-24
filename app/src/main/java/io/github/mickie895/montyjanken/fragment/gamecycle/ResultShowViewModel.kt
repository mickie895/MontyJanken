package io.github.mickie895.montyjanken.fragment.gamecycle

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mickie895.montyjanken.model.GameCycle
import io.github.mickie895.montyjanken.model.GameCycleRepository
import javax.inject.Inject

@HiltViewModel
class ResultShowViewModel @Inject constructor(private val gameCycleRepository: GameCycleRepository) :
    ViewModel() {
    fun resetGame() {
        gameCycleRepository.reset()
    }

    private val gameCycle: GameCycle.GameResult
        get() {
            when (val capturedCycle = gameCycleRepository.gameCycle) {
                is GameCycle.GameResult -> {
                    return capturedCycle
                }
                else -> throw IllegalStateException("ゲームの進行状況と画面が一致しません")
            }
        }

    val hasWon = gameCycle.hasWon

    val firstHand = gameCycle.gameState.playerStartHand

    val changed = gameCycle.handHasChanged

    val opponentHand = gameCycle.gameState.opponentHand
}
