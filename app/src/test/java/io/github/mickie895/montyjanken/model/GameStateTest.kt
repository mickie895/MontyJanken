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
                    game.canUseForGame(),
                )
            }
        }
    }

    /**
     * プレイヤーと対戦相手の出せる手の組み合わせを総当りで作成する
     */
    private val allHandPairs = Hand.values().map { player ->
        Hand.values().map { opponent ->
            Pair(player, opponent)
        }
    }.flatten()

    /**
     * ゲームの考えられる全遷移を、発生確率で重みを付けてリストで取得する
     */
    private val allGames: List<GameState> = allHandPairs.map { handPair ->
        val notUsedHands = GameState.getCanShowHands(handPair.first, handPair.second)

        /*
        プレイヤーが正解の手を選択できたときは2つ、
        そうでない場合は1つ、対戦相手が揺さぶりに使える手がでる。
        一つである場合の重み付けを条件分岐を使わず表現する。
         */
        val weightNotUsedHands =
            notUsedHands.toMutableList()
                .also {
                    it.addAll(notUsedHands)
                }.take(2)

        return@map weightNotUsedHands.map {
            GameState(handPair.first, handPair.second, it)
        }
    }.flatten()

    @Test
    fun montyHoleCount() {
        // モンティ・ホールジレンマに従ったときの勝ち数の確認

        // 手を変えなかったときの勝率
        val notChangedWinCount = allGames.count {
            it.matchWith(it.playerStartHand)
        }
        // 手を変えたときの勝率
        val changedWinCount = allGames.count { game ->
            game.matchWith(
                game.selectableHands.first {
                    it != game.playerStartHand
                },
            )
        }

        Assert.assertTrue("手を変えたほうが勝率が上がる", notChangedWinCount < changedWinCount)

        // より詳細な勝率チェック

        val allGameCount = allGames.count()
        Assert.assertEquals("手を変えなかった場合の勝率は1/3", notChangedWinCount, allGameCount / 3)
        Assert.assertEquals("手を帰る場合は2/3", changedWinCount, allGameCount * 2 / 3)
    }
}
