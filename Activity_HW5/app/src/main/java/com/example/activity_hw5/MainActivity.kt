package com.example.activity_hw5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {
    // 新的寫法
    private lateinit var txtCom: TextView
    private lateinit var txtResult: TextView
    private lateinit var btnScissors: ImageButton
    private lateinit var btnRock: ImageButton
    private lateinit var btnPaper: ImageButton
    private lateinit var imageView: ImageView
    private lateinit var btn_menu: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 原本的宣告變數
        //val txtCom = findViewById<TextView>(R.id.txtCom)
        //val txtResult = findViewById<TextView>(R.id.txtResult)
        //val btnScissors = findViewById<Button>(R.id.btnScissors)
        //val btnPaper = findViewById<Button>(R.id.btnPaper
        //val btnRock = findViewById<Button>(R.id.btnRock)

        // 新的寫法
        txtCom = findViewById(R.id.txtCom)
        txtResult = findViewById(R.id.txtResult)
        btnPaper = findViewById(R.id.btnPaper)
        btnRock = findViewById(R.id.btnRock)
        btnScissors = findViewById(R.id.btnScissors)
        imageView = findViewById(R.id.imageView2)
        btn_menu = findViewById(R.id.btn_menu_main)

        //設定電腦的隨機結果
        //已石頭的角度會發生的結果
        btnRock.setOnClickListener  {
            val iComPlay = Random().nextInt(3)+1

            when(iComPlay){
                1-> {
                    txtCom.setText(R.string.scissors) //剪刀
                    txtResult.setText(getString(R.string.win))
                }
                2-> {
                    txtCom.setText(R.string.rock) //石頭
                    txtResult.setText(getString(R.string.draw))
                }
                3-> {
                    txtCom.setText(R.string.paper) //布
                    txtResult.setText(getString(R.string.lose))
                }
            }
        }

        btnScissors.setOnClickListener  {
            playGame(Choice.SCISSORS)
        }
        btnRock.setOnClickListener  {
            playGame(Choice.ROCK)
        }
        btnPaper.setOnClickListener  {
            playGame(Choice.PAPER)
        }
        //返回鍵
        btn_menu = findViewById(R.id.btn_menu_main)

        btn_menu.setOnClickListener{
            var ThirdIntent = Intent(this,ThirdActivity::class.java)
            startActivity(ThirdIntent)
        }
    }

    enum class Choice { //列舉函數
        SCISSORS, ROCK, PAPER
    }
    fun playGame(playerChoice: Choice)  {
        val choises = Choice.values()
        val computerChoise = choises[Random().nextInt(choises.size)] //電腦的隨機結果

        when {
            playerChoice == computerChoise -> { //如果一樣則平手
                imageView.setImageResource(getChoiceString(computerChoise))
                txtResult.setText(R.string.draw)
            } //三種會贏的結果
            (playerChoice == Choice.SCISSORS && computerChoise == Choice.PAPER) ||
                    (playerChoice == Choice.ROCK && computerChoise == Choice.SCISSORS) ||
                    (playerChoice == Choice.PAPER && computerChoise == Choice.ROCK) -> {
                    imageView.setImageResource(getChoiceString(computerChoise))
                        txtResult.setText(R.string.win)
                    }
                    else -> { //反之不是贏的結果則輸
                        imageView.setImageResource(getChoiceString(computerChoise))
                        txtResult.setText(R.string.lose)
                    }
        }
    }
        fun getChoiceString(choice: Choice): Int { //以下為圖片設定 原為string表示
        return when (choice) {
            Choice.SCISSORS -> R.drawable.scissor
            Choice.ROCK -> R.drawable.rock
            Choice.PAPER -> R.drawable.paper

        }
    }
}