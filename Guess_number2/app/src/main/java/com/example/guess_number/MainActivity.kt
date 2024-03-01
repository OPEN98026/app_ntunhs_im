package com.example.guess_number

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val guess_button = findViewById<Button>(R.id.GUESS)
        val reset_button = findViewById<Button>(R.id.RESET)
        //val ANS_button = findViewById<Button>(R.id.ANS)
        val editText = findViewById<EditText>(R.id.editTextText)
        var validate_num:Int
        var str:Int = 1
        var end:Int = 100

        var secret : Int = Random().nextInt(100)+1 //確保生出來的數值正確階為設定值 1-10

        guess_button.setOnClickListener {
            //textView.text = editText.text
            validate_num=editText.text.toString().toInt()-secret
            var ans_str:String="你猜對了喔"

            if (validate_num>0){
                end = editText.text.toString().toInt()
                ans_str="$str ~ $end"
            }else if (validate_num<0) {
                str = editText.text.toString().toInt()
                ans_str="$str ~ $end"
            }
            textView.text=ans_str
        }

        reset_button.setOnClickListener{
            str = 1
            end = 100
            secret = Random().nextInt(100)+1
            textView.text="我們再猜一次"
        }

        //guess_button.setOnClickListener { //Toast之應用
        //    Toast.makeText(this,editText.text,Toast.LENGTH_LONG)
        //}

        //guess_button.setOnClickListener{ //Toast-alter
        //    Toast.makeText(this,editText.text,Toast.LENGTH_LONG).show()
        //    AlterDialog.Builder(this).setTitle("onclick").setMessage("onclick").create().show()
        //}

    }
}