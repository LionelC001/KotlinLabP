package com.lionel.kotlinp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var imgDice1: ImageView
    private lateinit var imgDice2: ImageView
    private lateinit var btnRoll: Button
    private lateinit var btnReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initView()
        initListener()
    }

    private fun initView() {
        imgDice1 = findViewById(R.id.imgDice1)
        imgDice2 = findViewById(R.id.imgDice2)
        btnRoll = findViewById(R.id.btnRoll)
        btnReset = findViewById(R.id.btnReset)
    }

    private fun initListener() {
        btnRoll.setOnClickListener { onBtnClicked() }
        btnReset.setOnClickListener { onReset() }
    }

    private fun onBtnClicked() {
        imgDice1.setImageResource(getRandomResDice())
        imgDice2.setImageResource(getRandomResDice())
    }

    private fun onReset() {
        imgDice1.setImageResource(R.drawable.dice_1)
        imgDice2.setImageResource(R.drawable.dice_1)
    }

    private fun getRandomResDice(): Int {
        return when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}
