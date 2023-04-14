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
        private fun handSetIsValidate(
            playerStartHand: Hand,
            opponentHand: Hand,
            opponentNotUseHand: Hand
        ): Boolean =
            opponentNotUseHand != opponentHand && (!playerStartHand.canWinTo(opponentNotUseHand))
    }

    @VisibleForTesting
    fun canUseForGame(): Boolean
        = handSetIsValidate(playerStartHand, opponentHand, opponentNotUseHand)
}