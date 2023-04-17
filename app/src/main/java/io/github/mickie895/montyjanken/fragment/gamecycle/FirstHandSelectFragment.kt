package io.github.mickie895.montyjanken.fragment.gamecycle

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.mickie895.montyjanken.R

class FirstHandSelectFragment : Fragment() {

    companion object {
        fun newInstance() = FirstHandSelectFragment()
    }

    private lateinit var viewModel: FirstHandSelectViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first_hand_select, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FirstHandSelectViewModel::class.java)
        // TODO: Use the ViewModel
    }

}