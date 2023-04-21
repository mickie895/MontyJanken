package io.github.mickie895.montyjanken.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.mickie895.montyjanken.model.GameCycleRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GameCycleEntryPoints {

    // 今のところ実装が変わることはないためProvidesを利用する。インタフェースを使い場合はBindsを使う

    @Provides
    @Singleton
    fun provideGameCycleRepository() : GameCycleRepository{
        return GameCycleRepository()
    }
}