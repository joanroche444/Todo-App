package com.example.taskapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)
        val thread = Thread {
            try {
                Thread.sleep(5000)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                val mainIntent = Intent(this, MainActivity::class.java)
                startActivity(mainIntent)
                finish()
            }
        }
        thread.start()
    }
    override fun onPause() {
        super.onPause()
        finish()
    }
}