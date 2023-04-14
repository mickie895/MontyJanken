package io.github.mickie895.montyjanken.model

import org.junit.Assert
import org.junit.Test

class GameStateTest {
    @Test
    fun checkGameIsValid() {
        // ランダム生成している手が有効であることの確認
        // 手の組み合わせがかなり限られるので適当な回数ランダムで生成させて確認すれば良い
        for (i in 1..100) {
            for (player in Hand.values()) {
                val game = GameState.startWithHand(player)
                Assert.assertTrue(
                    "ゲームが正常に初期化されることの確認",
                    game.canUseForGame()
                )
            }
        }
    }

    /**
     * ありうる状態を総当りで作成
     */
    private val gameHandSet = Hand.values().map { player ->
        Hand.values().map { opponent ->
            Hand.values().filter {
                GameState.handSetIsValidate(player, opponent, it)
            }.map { notUse ->
                Triple(player, opponent, notUse)
            }
        }.flatten()
    }.flatten()

    /**
     * ゲームの状態を全取得
     */
    private val allGames = gameHandSet.map {
        GameState(it.first, it.second, it.third)
    }.toList()

    @Test
    fun montyHoleCount() {
        // モンティ・ホールジレンマに従ったときの勝ち数の確認

        // 手を変えなかったときの勝率
        val notChangedWinCount = allGames.count{
            it.matchWith(it.playerStartHand)
        }
        // 手を変えたときの勝率
        val changedWinCount = allGames.count{ game ->
            game.matchWith(game.selectableHands.first {
                it != game.playerStartHand
            })
        }
        Assert.assertTrue("手を変えたほうが勝率が上がる", notChangedWinCount < changedWinCount)
    }
}