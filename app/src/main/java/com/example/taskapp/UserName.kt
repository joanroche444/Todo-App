package com.example.taskapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class UserName : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nameselect)
        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val submitButton = findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener {

            val name = nameEditText.text.toString().trim() // Get the name entered by the user
            if (name.isNotEmpty()) { // Check if the name is not empty
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("NAME", name) // Pass the name to MainActivity using an Intent extra
                startActivity(intent) // Start MainActivity
                finish() // Finish UserName activity
            } else {
                // Show a toast or some message indicating that the name is required
                //Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
        }

    }
}