package io.github.mickie895.montyjanken.fragment.gamecycle

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.mickie895.montyjanken.R

class ShowOpponentHandFragment : Fragment() {

    companion object {
        fun newInstance() = ShowOpponentHandFragment()
    }

    private lateinit var viewModel: ShowOppenentHandViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_opponent_hand, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShowOppenentHandViewModel::class.java)
        // TODO: Use the ViewModel
    }

}