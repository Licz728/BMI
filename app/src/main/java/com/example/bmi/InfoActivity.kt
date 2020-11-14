package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val buttonClose: Button = findViewById(R.id.buttonClose)
        buttonClose.setOnClickListener {
            //Close the current activity
            finish()
        }
    }
}