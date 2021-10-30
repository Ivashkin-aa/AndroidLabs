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

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        secondsElapsed = savedInstanceState.getInt(keyCounter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.continue_watch)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        backgroundThread.start()
    }

    override fun onStop() {
        super.onStop()
        access = false
    }

    override fun onStart() {
        super.onStart()
        access = true
    }

}