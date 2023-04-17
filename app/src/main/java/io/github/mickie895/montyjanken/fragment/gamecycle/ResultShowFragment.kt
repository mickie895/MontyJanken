package io.github.mickie895.montyjanken.fragment.gamecycle

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.mickie895.montyjanken.R

class ResultShowFragment : Fragment() {

    companion object {
        fun newInstance() = ResultShowFragment()
    }

    private lateinit var viewModel: ResultShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ResultShowViewModel::class.java)
        // TODO: Use the ViewModel
    }

}