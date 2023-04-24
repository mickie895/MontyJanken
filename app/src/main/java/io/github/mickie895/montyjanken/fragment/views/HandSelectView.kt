package io.github.mickie895.montyjanken.fragment.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import io.github.mickie895.montyjanken.R
import io.github.mickie895.montyjanken.databinding.ViewHandSelectBinding
import io.github.mickie895.montyjanken.model.Hand

interface OnHandSelectListener {
    fun handSelected(hand: Hand)
}

/**
 * 手を選ぶためのビュー
 */
class HandSelectView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {

    private val handViewDictionary: Map<Hand, View>

    init {
        // 手を選択するときのリスナの準備
        View.inflate(context, R.layout.view_hand_select, this)

        val binding = ViewHandSelectBinding.bind(this)
        binding.selectRock.setOnClickListener {
            selectedListener?.handSelected(Hand.ROCK)
        }
        binding.selectScissor.setOnClickListener {
            selectedListener?.handSelected(Hand.SCISSOR)
        }
        binding.selectPaper.setOnClickListener {
            selectedListener?.handSelected(Hand.PAPER)
        }

        handViewDictionary = mapOf(
            Hand.ROCK to binding.selectRock,
            Hand.SCISSOR to binding.selectScissor,
            Hand.PAPER to binding.selectPaper,
        )
    }

    /**
     * 利用不可能にする手を設定
     */
    fun setForbiddenHand(hand: Hand) {
        handViewDictionary.entries.forEach {
            it.value.isClickable = (hand != it.key)
        }
    }

    private var selectedListener: OnHandSelectListener? = null

    /**
     * 手を選択したときのリスナの登録
     */
    fun setOnSelectedListener(listener: OnHandSelectListener) {
        selectedListener = listener
    }
}
