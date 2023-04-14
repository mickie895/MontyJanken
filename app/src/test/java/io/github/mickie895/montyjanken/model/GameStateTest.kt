package io.github.mickie895.montyjanken.model

import org.junit.Assert
import org.junit.Test

class GameStateTest {
    @Test
    fun checkGameIsValid(){
        // ランダム生成している手が有効であることの確認
        // 手の組み合わせがかなり限られるので適当な回数ランダムで生成させて確認すれば良い
        for (i in 1..100){
            for (player in Hand.values()) {
                val game = GameState.startWithHand(player)
                Assert.assertTrue("ゲームが正常に初期化されることの確認",
                    game.canUseForGame())
            }
        }
    }
}