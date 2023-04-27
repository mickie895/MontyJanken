package io.github.mickie895.montyjanken.model

import javax.inject.Inject

class StaticsChangeReceiver @Inject constructor(private val staticsChangedNotify: StaticsChangedNotify) {
    fun setOnStaticsChangedListener(listener: StaticsChangedNotify.StaticsChangedListener) {
        staticsChangedNotify.setOnStaticsChangedListener(listener)
    }
}
