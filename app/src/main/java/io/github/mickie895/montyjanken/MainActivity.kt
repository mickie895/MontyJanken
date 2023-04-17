package io.github.mickie895.montyjanken

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.mickie895.montyjanken.fragment.menuscreen.MainMenuFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainMenuFragment.newInstance())
                .commitNow()
        }
    }
}