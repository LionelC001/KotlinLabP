package com.lionel.kotlinp

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ColorMyViewsActivity : AppCompatActivity() {
    private lateinit var layoutColorMyViews: View
    private lateinit var txtBoxOne: TextView
    private lateinit var txtBoxTwo: TextView
    private lateinit var txtBoxThree: TextView
    private lateinit var txtBoxFour: TextView
    private lateinit var txtBoxFive: TextView
    private lateinit var btnRed: Button
    private lateinit var btnYellow: Button
    private lateinit var btnGreen: Button

    private lateinit var clickableViews: List<View>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_my_views)

        initView()
        initListener()
    }

    private fun initView() {
        layoutColorMyViews = findViewById(R.id.layoutColorMyViews)
        txtBoxOne = findViewById(R.id.txtBoxOne)
        txtBoxTwo = findViewById(R.id.txtBoxTwo)
        txtBoxThree = findViewById(R.id.txtBoxThree)
        txtBoxFour = findViewById(R.id.txtBoxFour)
        txtBoxFive = findViewById(R.id.txtBoxFive)
        btnRed = findViewById(R.id.btnRed)
        btnGreen = findViewById(R.id.btnGreen)
        btnYellow = findViewById(R.id.btnYellow)

        clickableViews = listOf(layoutColorMyViews, txtBoxOne, txtBoxTwo, txtBoxThree, txtBoxFour, txtBoxFive, btnRed, btnGreen, btnYellow)
    }

    private fun initListener() {
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    fun makeColored(view: View) {
        when (view.id) {
            R.id.txtBoxOne -> view.setBackgroundColor(Color.DKGRAY)
            R.id.txtBoxTwo -> view.setBackgroundColor(Color.GRAY)
            R.id.txtBoxThree -> view.setBackgroundColor(Color.BLUE)
            R.id.txtBoxFour -> view.setBackgroundColor(Color.MAGENTA)
            R.id.txtBoxFive -> view.setBackgroundColor(Color.BLUE)
            R.id.btnRed -> txtBoxThree.setBackgroundResource(R.color.colorRed)
            R.id.btnYellow -> txtBoxFour.setBackgroundResource(R.color.colorYellow)
            R.id.btnGreen -> txtBoxFive.setBackgroundResource(R.color.colorGreen)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

}
