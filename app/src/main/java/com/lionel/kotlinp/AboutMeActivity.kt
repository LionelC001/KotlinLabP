package com.lionel.kotlinp

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutMeActivity : AppCompatActivity() {

    private lateinit var edtNickName: EditText
    private lateinit var txtNickName: TextView
    private lateinit var btnDone: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        initView()
        initListener()
    }


    private fun initView() {
        edtNickName = findViewById(R.id.edtNickName)
        txtNickName = findViewById(R.id.txtNickName)
        btnDone = findViewById(R.id.btnDone)
    }

    private fun initListener() {
        btnDone.setOnClickListener { addNickName() }
        txtNickName.setOnClickListener { updateNickName() }
    }


    private fun addNickName() {
        txtNickName.text = edtNickName.text
        edtNickName.visibility = GONE
        btnDone.visibility = GONE
        txtNickName.visibility = VISIBLE

        //hide the keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(btnDone.windowToken, 0)
    }

    private fun updateNickName() {
        txtNickName.visibility = GONE
        edtNickName.visibility = VISIBLE
        btnDone.visibility = VISIBLE

        edtNickName.requestFocus()

        //show the keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(edtNickName,0)
    }
}
