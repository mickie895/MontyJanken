package io.github.mickie895.montyjanken.fragment.gamecycle

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import io.github.mickie895.montyjanken.R
import io.github.mickie895.montyjanken.model.Hand

/**
 * じゃんけんの手とリソースの変換コード
 */
@StringRes
fun handToResource(hand: Hand): Int = when (hand) {
    Hand.ROCK -> R.string.hand_rock
    Hand.SCISSOR -> R.string.hand_scissor
    Hand.PAPER -> R.string.hand_paper
}

/**
 * じゃんけんの手を文字列に変換するためのコード
 */
internal fun Fragment.handToString(hand: Hand): String = this.getString(handToResource(hand))