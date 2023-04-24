package io.github.mickie895.montyjanken.model.statics

import io.github.mickie895.montyjanken.model.Hand

/**
 * ゲーム全体の記録用データ
 */
data class GameHistory(
    val gameCount: Int,
    val winCount: Int,
)

/**
 * 一回のゲームの記録用データ
 */
data class GameSummary constructor(
    val firstPlayerHand: Hand,
    val opponentHand: Hand,
    val lastPlayerHand: Hand,
    val handsChanged: Boolean,
    val hasWon: Boolean,
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
