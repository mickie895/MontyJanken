package io.github.mickie895.montyjanken.model.statics

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.github.mickie895.montyjanken.model.Hand

data class GameHistory(
    val gameCount: Int,
    val winCount: Int,
) {
    companion object {
        /**
         * DAO経由で勝敗をカウントに変更する
         */
        fun fromGameCountList(source: Map<Boolean, Int>): GameHistory {
            return GameHistory(
                source.values.sum(),
                source.getOrDefault(true, 0),
            )
        }
    }

    /**
     * 勝率（100分率）
     */
    val winRate: Int = when (gameCount) {
        0 -> 0
        else -> winCount * 100 / gameCount
    }
}

/**
 * ゲーム全体の記録用データ
 */
data class GameStatics(
    val allCount: GameHistory,
    val handChangedCount: GameHistory,
    val handNotChangedCount: GameHistory,
)

/**
 * 一回のゲームの記録用データ
 */
@Entity
data class GameSummary constructor(
    val firstPlayerHand: Hand,
    val opponentHand: Hand,
    val lastPlayerHand: Hand,
    val handsChanged: Boolean,
    val hasWon: Boolean,
    @PrimaryKey(autoGenerate = true)
    val gameId: Int = 0,
) {

    constructor(
        firstPlayerHand: Hand,
        opponentHand: Hand,
        lastPlayerHand: Hand,
    ) : this(
        firstPlayerHand,
        opponentHand,
        lastPlayerHand,
        firstPlayerHand != lastPlayerHand,
        lastPlayerHand.canWinTo(opponentHand),
    )
}
