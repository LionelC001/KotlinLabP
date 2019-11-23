package com.lionel.kotlinp.about_me

import android.content.Context
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lionel.kotlinp.R
import com.lionel.kotlinp.databinding.ActivityAboutMeBinding

class AboutMeActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityAboutMeBinding
    private lateinit var edtNickName: EditText
    private lateinit var txtNickName: TextView
    private lateinit var btnDone: Button

    private val myName: MyName = MyName("Lionel")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_about_me)
        dataBinding.myName = myName

        initView()
        initListener()
    }


    private fun initView() {
        edtNickName = dataBinding.edtNickName
        txtNickName = dataBinding.txtNickName
        btnDone = dataBinding.btnDone
    }

    private fun initListener() {
        btnDone.setOnClickListener { addNickName() }
        txtNickName.setOnClickListener { updateNickName() }
    }


    private fun addNickName() {
        myName.nickname = edtNickName.text.toString()
        dataBinding.invalidateAll()

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
        inputMethodManager.showSoftInput(edtNickName, 0)
    }
}
