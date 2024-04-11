package com.example.test0411

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.util.Log

class MainActivity : AppCompatActivity() {
    private lateinit var editphone : EditText
    private lateinit var spinner1: Spinner
    private lateinit var spinner2 : Spinner
    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox
    private lateinit var btnsend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editphone = findViewById(R.id.editphone)
        spinner1 = findViewById(R.id.spinner1)
        spinner2 = findViewById(R.id.spinner2)
        checkBox1 = findViewById(R.id.checkBox1)
        checkBox2 = findViewById(R.id.checkBox2)
        btnsend = findViewById(R.id.btnsend)

        val adapter1 = ArrayAdapter.createFromResource(this,R.array.bigpeople,android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = adapter1

        val adapter2 = ArrayAdapter.createFromResource(this,R.array.childpeople,android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = adapter2

        btnsend.setOnClickListener {
            fun buildMessage(): String {
                var msg = ""

                if (checkBox1.isChecked) {
                    msg += "需要${checkBox1.text.toString()}"
                }
                if (checkBox2.isChecked) {
                    if (msg.isNotEmpty()) {
                        msg += "、"
                    }
                    msg += checkBox2.text.toString()
                }
                return msg
            }

            val msg = buildMessage()
            val spinner1Value = spinner1.selectedItem.toString() // 获取 spinner1 的选中值并转换为字符串
            val spinner2Value = spinner2.selectedItem.toString() // 获取 spinner2 的选中值并转换为字符串
            val phone = editphone.text.toString() // 获取 editphone   的文本内容

            Log.e("Page Output", "Message: $msg, Spinner1 Value: $spinner1Value, Spinner2 Value: $spinner2Value, Phone: $phone")


            val secondIntent = Intent(this, SecondActivity::class.java)
            secondIntent.putExtra("message", msg) // 将 msg 放入 Intent 的 extras 中
            secondIntent.putExtra("spinner1Value", spinner1Value) // 将 spinner1 的选中值放入 Intent 的 extras 中
            secondIntent.putExtra("spinner2Value", spinner2Value) // 将 spinner2 的选中值放入 Intent 的 extras 中
            secondIntent.putExtra("phone", phone)
            startActivity(secondIntent)
        }
    }

}