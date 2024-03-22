package com.example.rock_paper_scissors

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

        btnRock.setOnClickListener  {
            val iComPlay = Random().nextInt(3)+1

            when(iComPlay){
                1-> {
                    txtCom.setText(R.string.scissors)
                    txtResult.setText(getString(R.string.win))
                }
                2-> {
                    txtCom.setText(R.string.rock)
                    txtResult.setText(getString(R.string.draw))
                }
                3-> {
                    txtCom.setText(R.string.paper)
                    txtResult.setText(getString(R.string.lose))
                }
            }
        }
        btnScissors.setOnClickListener  {
            playGame(Choise.SCISSORS)
        }
        btnRock.setOnClickListener  {
            playGame(Choise.ROCK)
        }
        btnPaper.setOnClickListener  {
            playGame(Choise.PAPER)
        }
    }

    enum class Choise {
        SCISSORS, ROCK, PAPER
    }
    fun playGame(playerChoice: Choise)  {
        val choises = Choise.values()
        val computerChoise = choises[Random().nextInt(choises.size)]

        when {
            playerChoice == computerChoise -> {
                imageView.setImageResource(getChoiceString(computerChoise))
                txtResult.setText(R.string.draw)
            } //三種可能的結果
            (playerChoice == Choise.SCISSORS && computerChoise == Choise.PAPER) ||
                    (playerChoice == Choise.ROCK && computerChoise == Choise.SCISSORS) ||
                    (playerChoice == Choise.PAPER && computerChoise == Choise.ROCK) -> {
                    imageView.setImageResource(getChoiceString(computerChoise))
                        txtResult.setText(R.string.win)
                    }
                    else -> {
                        imageView.setImageResource(getChoiceString(computerChoise))
                        txtResult.setText(R.string.lose)
                    }
        }
    }
        fun getChoiceString(choice: Choise): Int {
        return when (choice) {
            Choise.SCISSORS -> R.drawable.scissor
            Choise.ROCK -> R.drawable.rock
            Choise.PAPER -> R.drawable.paper

        }
    }
}