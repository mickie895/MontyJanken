package io.github.mickie895.montyjanken.model

/**
 * このじゃんけんアプリ全体の状態をDIコンテナで表現するために準備する
 */
class ApplicationState {
    var game:GameCycle = GameCycle.Start
}