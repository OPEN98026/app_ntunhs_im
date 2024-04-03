package com.example.activity_hw5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        var btnGN = findViewById<Button>(R.id.btnGN)
        var btnRcokPaperScissior = findViewById<Button>(R.id.btnRPS)

        btnGN.setOnClickListener{
            var MainIntent = Intent(this,SecondActivity::class.java)
            startActivity(MainIntent)
        }

        btnRcokPaperScissior.setOnClickListener{
            var SecondIntent = Intent(this,MainActivity::class.java)
            startActivity(SecondIntent)
        }
    }
}