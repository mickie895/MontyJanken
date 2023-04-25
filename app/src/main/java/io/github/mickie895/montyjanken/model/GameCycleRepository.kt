package io.github.mickie895.montyjanken.model

import io.github.mickie895.montyjanken.model.statics.GameSummary

/**
 * DI用にゲームの状態を保管するリポジトリ
 */
class GameCycleRepository {
    var gameCycle: GameCycle = GameCycle.Start

    fun proceed(hand: Hand) {
        gameCycle = gameCycle.getNextInstanceWith(hand)
    }

    fun reset() {
        gameCycle = gameCycle.reset()
    }

    val tryGetSummary: GameSummary?
        get() = when (val capturedCycle = gameCycle) {
            is GameCycle.GameResult -> capturedCycle.summary()
            else -> null
        }
}
