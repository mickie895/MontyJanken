package io.github.mickie895.montyjanken.model

import org.junit.Assert
import org.junit.Test

class HandTest {

    @Test
    fun canWinTo() {
        Assert.assertTrue(Hand.PAPER.canWinTo(Hand.ROCK))
        Assert.assertTrue(Hand.ROCK.canWinTo(Hand.SCISSOR))
        Assert.assertTrue(Hand.SCISSOR.canWinTo(Hand.PAPER))
    }
}