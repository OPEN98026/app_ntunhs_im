package com.example.guess_number
import java.util.Random

class guessClass {
    private var secret = Random().nextInt(100) + 1 //確保生出來的數值正確階為設定值 1-100
    var minNum = 0
    var maxNum = 100

    fun guessNumber(guess: Int): String {
        if (guess > maxNum || guess < minNum) { //如果這個輸入超出這個範圍 則重新自訂範圍
            return "請輸入位於${minNum}~${maxNum}的數字"
        }
        when {
            guess > secret -> {
                maxNum = guess
                return "你猜得比較大喔"
            }
            guess < secret -> {
                minNum = guess
                return "你猜的比較小喔"
            }
            else -> {
                resetGame()
                return "猜對了"
            }
        }
    }
    fun getRangeText(): String = "$minNum~$maxNum"

    fun resetGame() {
        secret = Random().nextInt(100) + 1
        maxNum = 100
        minNum = 0
    }
}