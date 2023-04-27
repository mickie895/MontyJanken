package io.github.mickie895.montyjanken.room

import androidx.room.*
import io.github.mickie895.montyjanken.model.statics.GameHistory
import io.github.mickie895.montyjanken.model.statics.GameStatics
import io.github.mickie895.montyjanken.model.statics.GameSummary

@Dao
interface GameSummaryDao {
    @Insert
    fun registerHistory(gameSummary: GameSummary)

    @Query("DELETE FROM GameSummary")
    fun clearHistory()

    @MapInfo(keyColumn = "hasWon", valueColumn = "count")
    @Query("SELECT hasWon, count(hasWon) AS count FROM GameSummary GROUP BY hasWon")
    fun getAllGameCount(): Map<Boolean, Int>

    @MapInfo(keyColumn = "hasWon", valueColumn = "count")
    @Query("SELECT hasWon, count(hasWon) AS count FROM GameSummary WHERE handsChanged = TRUE GROUP BY hasWon")
    fun getChangedGameCount(): Map<Boolean, Int>

    @MapInfo(keyColumn = "hasWon", valueColumn = "count")
    @Query("SELECT hasWon, count(hasWon) AS count FROM GameSummary WHERE handsChanged = FALSE GROUP BY hasWon")
    fun getNotChangedGameCount(): Map<Boolean, Int>

    fun createGameStatics(): GameStatics {
        val allGame = GameHistory.fromGameCountList(getAllGameCount())
        val changedGame = GameHistory.fromGameCountList(getChangedGameCount())
        val notChangedGame = GameHistory.fromGameCountList(getNotChangedGameCount())
        return GameStatics(allGame, changedGame, notChangedGame)
    }
}
