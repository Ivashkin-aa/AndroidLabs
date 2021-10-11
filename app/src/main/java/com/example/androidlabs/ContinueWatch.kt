package com.example.androidlabs

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContinueWatch : AppCompatActivity() {

    private val keyCounter = "counter"
    private var secondsElapsed: Int = 0
    private lateinit var textSecondsElapsed: TextView
    private var access = true

    private var backgroundThread = Thread {
        while (true) {
            Thread.sleep(1000)
            if (access) {
                secondsElapsed++
                textSecondsElapsed.post {
                    textSecondsElapsed.text = getString(R.string.seconds, secondsElapsed)
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(keyCounter, secondsElapsed)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        secondsElapsed = savedInstanceState?.getInt(keyCounter) ?: 0
        setContentView(R.layout.continue_watch)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        backgroundThread.start()
    }

    override fun onPause() {
        super.onPause()
        access = false
    }

    override fun onResume() {
        super.onResume()
        access = true
    }

}