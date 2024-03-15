package com.example.form

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //這整串都是寫spinner的程式但作業無需用到。
        //val spnCity = findViewById<Spinner>(R.id.spinner)
        //val adapter = ArrayAdapter.createFromResource(this, R.array.city,
        //                                                android.R.layout.simple_spinner_dropdown_item)
        //spnCity.adapter = adapter

        //spnCity.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
        //    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
        //        val city = resources.getStringArray(R.array.city)
        //        if(pos>0)
        //            Toast.makeText(this@MainActivity,"你選的是"+ city[pos],
        //                                                            Toast.LENGTH_SHORT).show()
        //    }
        //    override fun onNothingSelected(parent: AdapterView<*>) {}

        // 單選問題 選擇男女
        val radGrp_Gender = findViewById<RadioGroup>(R.id.radGrpGender)
        val radBtn_Male = findViewById<RadioButton>(R.id.radbtn_Male)
        val radBtn_Female = findViewById<RadioButton>(R.id.radbtn_Female)
        var gender=""
        radGrp_Gender.setOnCheckedChangeListener{ _,checkedId ->
            gender = when(checkedId){
                R.id.radbtn_Female -> radBtn_Female.text.toString()
                R.id.radbtn_Male ->radBtn_Male.text.toString()
                else -> "I don't know"
            }
            //Toast.makeText(this,gender,Toast.LENGTH_SHORT).show()
        }
        // checkBox的按鈕
        val checkBox1 = findViewById<CheckBox>(R.id.ckb1)
        val checkBox2 = findViewById<CheckBox>(R.id.ckb2)
        val checkBox3 = findViewById<CheckBox>(R.id.ckb3)
        val checkBox4 = findViewById<CheckBox>(R.id.ckb4)
        val btn_send = findViewById<Button>(R.id.btn_send)

        //text文字
        val ID = findViewById<EditText>(R.id.IDText)
        val PWD = findViewById<EditText>(R.id.PWDText)
        val Name = findViewById<EditText>(R.id.NameText)
        val Birth = findViewById<EditText>(R.id.BirthdayText)

        //btn按鈕
        btn_send.setOnClickListener {
            var msg=""
            if(checkBox1.isChecked()) {
                msg = msg + checkBox1.getText().toString()
            }
            if(checkBox2.isChecked()) {
                msg = msg + "、" + checkBox2.getText().toString()
            }
            if(checkBox3.isChecked()) {
                msg = msg + "、" + checkBox3.getText().toString()
            }
            if(checkBox4.isChecked()) {
                msg = msg + "、" + checkBox4.getText().toString()
            }
            AlertDialog.Builder(this)
                .setTitle("表單")
                .setMessage(
                        "你的ID是：${ID.text}\n"+
                        "你的密碼是：${PWD.text}\n"+
                        "你的名子是：${Name.text}\n"+
                        "你的生日是：${Birth.text}\n"+
                        "你選擇的性別是：$gender\n"+
                        "你選的興趣是：$msg")
                .setPositiveButton("OK", null)
                .setNeutralButton("Cancel", null)
                .create().show()
            //Toast.makeText(this@MainActivity, "你選的是" + msg,
            //    Toast.LENGTH_SHORT).show()
        }
    }
}