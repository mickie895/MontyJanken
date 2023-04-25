package io.github.mickie895.montyjanken.model

import io.github.mickie895.montyjanken.model.statics.GameStatics
import io.github.mickie895.montyjanken.model.statics.GameSummary
import io.github.mickie895.montyjanken.room.AppDatabase
import io.github.mickie895.montyjanken.room.GameSummaryDao
import javax.inject.Inject

class GameSummaryRepository @Inject constructor(database: AppDatabase) {
    private val dao: GameSummaryDao = database.gameSummaryDao()

    fun addToHistory(gameSummary: GameSummary) {
        dao.registerHistory(gameSummary)
    }

    fun getStatics(): GameStatics {
        return dao.createGameStatics()
    }
}
