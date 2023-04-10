package io.github.mickie895.montyjanken.model

enum class Hand {
    ROCK,
    SCISSOR,
    PAPER;

    fun canWinTo(opponent: Hand): Boolean {
        return when (this) {
            ROCK -> opponent == SCISSOR
            SCISSOR -> opponent == PAPER
            PAPER -> opponent == ROCK
        }
    }
}