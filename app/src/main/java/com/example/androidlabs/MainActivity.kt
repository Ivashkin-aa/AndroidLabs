package com.example.androidlabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val tag = "Lifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_1_10)

        Log.i(tag, "onCreate()")
    }

    fun newActivity(view: android.view.View) {}

    override fun onStart() {
        super.onStart()
        Log.i(tag, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(tag, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(tag, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(tag, "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(tag, "onDestroy()")
    }
}