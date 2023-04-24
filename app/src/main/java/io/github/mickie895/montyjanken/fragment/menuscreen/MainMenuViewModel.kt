package io.github.mickie895.montyjanken.fragment.menuscreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mickie895.montyjanken.model.GameCycleRepository
import javax.inject.Inject

@HiltViewModel
class MainMenuViewModel @Inject constructor(val gameCycleRepository: GameCycleRepository): ViewModel() {
    fun startGame(){
        gameCycleRepository.reset()
    }
}