package io.github.mickie895.montyjanken.model

/**
 * DI用にゲームの状態を保管するリポジトリ
 */
class GameCycleRepository {
    var gameCycle: GameCycle = GameCycle.Start

    fun proceed(hand: Hand) {
        gameCycle = gameCycle.getNextInstanceWith(hand)
    }

    fun reset() {
        gameCycle = gameCycle.reset()
    }
}
