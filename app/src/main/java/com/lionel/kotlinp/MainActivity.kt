package com.lionel.kotlinp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var txtView: TextView
    lateinit var btnRoll: Button
    lateinit var btnCountUp: Button
    lateinit var btnReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        initView()
        initListener()
    }

    private fun initView() {
        txtView = findViewById(R.id.txtView)
        btnRoll = findViewById(R.id.btnRoll)
        btnCountUp = findViewById(R.id.btnCountUp)
        btnReset = findViewById(R.id.btnReset)
    }

    private fun initListener() {
        btnRoll.setOnClickListener { onBtnClicked() }
        btnCountUp.setOnClickListener { onCountUp() }
        btnReset.setOnClickListener { onReset() }
    }

    private fun onBtnClicked() {
        val iRandom = (1..6).random()
        txtView.text = iRandom.toString()

    }

    private fun onCountUp() {
        var count = txtView.text.toString().toIntOrNull()

        if (count != null) {
            if (count < 6) count++
        } else {
            count = 1
        }

        txtView.text = count.toString()
    }

    private fun onReset() {
        txtView.text = 0.toString()
    }
}
