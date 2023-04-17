package io.github.mickie895.montyjanken.fragment.menuscreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.mickie895.montyjanken.R

class MainMenuFragment : Fragment() {

    companion object {
        fun newInstance() = MainMenuFragment()
    }

    private lateinit var viewModel: MainMenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainMenuViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

}