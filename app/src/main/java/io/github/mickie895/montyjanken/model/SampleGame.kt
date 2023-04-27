package io.github.mickie895.montyjanken.model

import io.github.mickie895.montyjanken.model.statics.GameSummary

object SampleGame {
    /**
     * プレイヤーが手を変えなかったときの結果のサンプルを取得する
     */
    fun sampleHandNotChange(): GameSummary {
        val gameState = GameState.startWithHand(Hand.values().random())
        return GameSummary(gameState.playerStartHand, gameState.opponentHand, gameState.playerStartHand)
    }

    /**
     * プレイヤーが手を変えたときの結果のサンプルを取得する
     */
    fun sampleHandChange(): GameSummary {
        val gameState = GameState.startWithHand(Hand.values().random())
        return GameSummary(
            gameState.playerStartHand,
            gameState.opponentHand,
            Hand.values().first {
                it != gameState.playerStartHand && !it.canWinTo(gameState.opponentNotUseHand)
            },
        )
    }
}
