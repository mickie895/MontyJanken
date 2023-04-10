package io.github.mickie895.montyjanken.model

import org.junit.Assert
import org.junit.Test

class HandTest {

    @Test
    fun canWinTo() {
        Assert.assertTrue(Hand.PAPER.canWinTo(Hand.PAPER))
    }
}