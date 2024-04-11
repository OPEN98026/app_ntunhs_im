package com.example.test0411

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var number: TextView
    private lateinit var people: TextView
    private lateinit var need: TextView
    private lateinit var btnback: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        number = findViewById(R.id.number)
        people = findViewById(R.id.people)
        need = findViewById(R.id.need)
        btnback = findViewById(R.id.btnback)

        // 获取传递的消息
        val message = intent.getStringExtra("message")
        // 获取传递的 spinner1 的选中值
        val spinner1Value = intent.getStringExtra("spinner1Value")
        // 获取传递的 spinner2 的选中值
        val spinner2Value = intent.getStringExtra("spinner2Value")
        // 获取传递的电话号码
        val phone = intent.getStringExtra("phone")

        // 在布局中找到对应的 TextView
        val textView1: TextView = findViewById(R.id.number)
        val textView2: TextView = findViewById(R.id.people)
        val textView3: TextView = findViewById(R.id.need)

        // 设置 TextView 显示的内容
        textView1.text = "訂位電話: $phone"
        textView2.text = "訂位人數: $spinner1Value 大, $spinner2Value 小"
        textView3.text = "$message"

        btnback.setOnClickListener {
            var MainIntent = Intent(this, MainActivity::class.java)
            startActivity(MainIntent)
        }
    }
}