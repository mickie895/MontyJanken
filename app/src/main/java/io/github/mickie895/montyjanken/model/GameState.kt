package io.github.mickie895.montyjanken.model

import androidx.annotation.VisibleForTesting

class GameState
@VisibleForTesting
constructor(
    val playerStartHand: Hand,
    /**
     * 対戦相手の手
     */
    val opponentHand: Hand,
    /**
     * 揺さぶりとして提示される手
     */
    val opponentNotUseHand: Hand
) {
    companion object {
        /**
         * 与えられたプレイヤーの手からゲームを開始する
         */
        fun startWithHand(playerStartHand: Hand): GameState {
            val opponentHand = Hand.values().random()
            return GameState(
                playerStartHand,
                opponentHand,
                showNotUseHand(playerStartHand, opponentHand)
            )
        }

        /**
         * プレイヤーに見せる揺さぶり用の手を提示する
         */
        private fun showNotUseHand(playerStartHand: Hand, opponentHand: Hand) =
            Hand.values().filter {
                handSetIsValidate(playerStartHand, opponentHand, it)
            }.random()

        /**
         * 手の組み合わせが成り立っているかどうかのチェック
         */
        @VisibleForTesting
        fun handSetIsValidate(
            playerStartHand: Hand,
            opponentHand: Hand,
            opponentNotUseHand: Hand
        ): Boolean =
            opponentNotUseHand != opponentHand && (!playerStartHand.canWinTo(opponentNotUseHand))
    }

    @VisibleForTesting
    fun canUseForGame(): Boolean =
        handSetIsValidate(playerStartHand, opponentHand, opponentNotUseHand)

    /**
     * 二度目に選択できる手の提示
     * (じゃんけんのため、手は2つであることが保証できる)
     */
    val selectableHands: List<Hand> = Hand.values().filterNot { it.canWinTo(opponentNotUseHand) }

    /**
     * 最終的な手の確定及び勝負の結果の取得
     */
    fun matchWith(finalPlayerHand: Hand): Boolean = finalPlayerHand.canWinTo(opponentHand)
}