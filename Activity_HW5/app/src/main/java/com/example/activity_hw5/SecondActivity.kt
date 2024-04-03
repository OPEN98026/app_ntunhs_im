package com.example.activity_hw5

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class SecondActivity : AppCompatActivity() {
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        handler = Handler(Looper.getMainLooper())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var btnbackment = findViewById<Button>(R.id.btn_menu_sec)
        val textView = findViewById<TextView>(R.id.textView)
        val guess_button = findViewById<Button>(R.id.GUESS)
        val reset_button = findViewById<Button>(R.id.RESET)
        val editText = findViewById<EditText>(R.id.editTextText)
        var validate_num: Int
        var str: Int = 1
        var end: Int = 100

        btnbackment.setOnClickListener {
            var ThirdIntent = Intent(this, ThirdActivity::class.java)
            startActivity(ThirdIntent)
        }

        var secret: Int = Random().nextInt(100) + 1
        guess_button.setOnClickListener {
            textView.text = editText.text
            validate_num = editText.text.toString().toInt() - secret
            var ans_str: String

            if (validate_num > 0) {
                end = editText.text.toString().toInt()
                ans_str = "$str ~ $end"
            } else if (validate_num < 0) {
                str = editText.text.toString().toInt()
                ans_str = "$str ~ $end"
            } else if (validate_num == 0) {
                ans_str = "Yes, you got the answer"

                handler.postDelayed({
                    str = 1
                    end = 100
                    secret = Random().nextInt(100) + 1
                    textView.text = "try again"
                }, 5000)
            } else {
                ans_str = "" // 在validate_num不等於0的狀況設為""
            }
            textView.text = ans_str
        }

        reset_button.setOnClickListener {
            str = 1
            end = 100
            secret = Random().nextInt(100) + 1
            textView.text = "try again"
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}