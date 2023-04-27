package io.github.mickie895.montyjanken.model

/**
 * 統計データの変更を検知するためのデータ
 */
class StaticsChangedNotify {
    interface StaticsChangedListener {
        fun onStaticsChanged()
    }

    private var staticsChangedListener: StaticsChangedListener? = null

    /**
     * 通知先の登録
     */
    fun setOnStaticsChangedListener(listener: StaticsChangedListener) {
        staticsChangedListener = listener
    }

    /**
     * 変更があったことを通知する
     * ライフサイクルに関しては一切考慮していないので、使い方には注意。
     */
    fun notifyStaticsChanged() {
        staticsChangedListener?.onStaticsChanged()
    }
}
