package io.github.mickie895.montyjanken.model

import javax.inject.Inject

class StaticsChangeNotifySender @Inject constructor(private val staticsChangedNotify: StaticsChangedNotify) {
    fun notifyStaticsChanged() {
        staticsChangedNotify.notifyStaticsChanged()
    }
}
