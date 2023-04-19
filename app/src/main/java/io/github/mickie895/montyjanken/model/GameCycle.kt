package io.github.mickie895.montyjanken.model

import io.github.mickie895.montyjanken.model.statics.GameSummary

/**
 * ゲームの遷移をシールクラスで表現する
 */
sealed interface GameCycle{
    /**
     * プレイヤーが手を決めて先に進む
     */
    fun proceed(hand: Hand): GameCycle

    /**
     * 初期状態へリセットする
     */
    fun reset(): GameCycle = Start

    /**
     * 開始時の何も情報を作成していない状態
     */
    object Start : GameCycle {
        override fun proceed(hand: Hand): GameCycle {
            return HandSelected(hand)
        }
    }

    /**
     * プレイヤーが最初に手を選択した状態
     */
    class HandSelected(selectedHand: Hand): GameCycle{
        val gameState = GameState.startWithHand(selectedHand)

        override fun proceed(hand: Hand): GameCycle {
            return GameResult(this, hand)
        }
    }

    /**
     * 二度目に手を選択して勝負が終わった状態
     */
    class GameResult(game: HandSelected, val finalSelectedHand: Hand): GameCycle{
        val gameState = game.gameState
        val handHasChanged = gameState.playerStartHand != finalSelectedHand
        val hasWon = gameState.matchWith(finalSelectedHand)

        override fun proceed(hand: Hand): GameCycle {
            // 絶対通らない処理。
            throw IllegalStateException("ゲーム遷移上間違った操作が行われています")
        }

        fun summary(): GameSummary
        = GameSummary(gameState.playerStartHand, gameState.opponentHand, finalSelectedHand)
    }
}
