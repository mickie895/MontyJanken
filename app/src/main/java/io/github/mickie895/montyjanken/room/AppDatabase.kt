package io.github.mickie895.montyjanken.room

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.mickie895.montyjanken.model.statics.GameSummary

@Database(entities = [GameSummary::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameSummaryDao(): GameSummaryDao
}
