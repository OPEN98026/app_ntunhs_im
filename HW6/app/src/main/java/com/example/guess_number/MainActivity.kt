package com.example.guess_number

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.guess_number.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val TAG: String = MainActivity::class.java.simpleName
    private lateinit var handler: Handler
    private lateinit var binding: ActivityMainBinding
    private val game = guessClass()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler = Handler(Looper.getMainLooper())

        binding.GUESS.setOnClickListener {//GUESS button設定
            val guessNum = binding.editTextText.text.toString().toInt() //抓edit的內容
            val resultText = game.guessNumber(guessNum) //result = guessClass的guessNum函式)

            binding.textView.text = game.getRangeText() //設定猜大猜小範圍的$minNum~$maxNum
            binding.result.text = resultText //result是輸出中文字的新textView
            if (resultText == "猜對了") { //去抓guessClass else=猜對了的結果
                handler.postDelayed({
                    Toast.makeText(this, "六秒後重置", Toast.LENGTH_SHORT).show()
                    game.resetGame()
                    binding.result.text = "新的一局！！！"
                    binding.textView.text = "下一回合"
                }, 6000)
            }
        }
        binding.RESET.setOnClickListener {
            game.resetGame()
            binding.result.text = "再猜一次"
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}