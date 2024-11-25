package com.example.sergeevaaa_01_03

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ResultScreen : AppCompatActivity() {

    private lateinit var number : TextView
    private lateinit var resul : TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)
        number = findViewById(R.id.numb)
        resul = findViewById(R.id.result)

        //достаём значения, которые передали со второго экрана
        val resu = intent.getStringExtra("result")
        val n = intent.getStringExtra("number")
        //округляем значения
        val round = String.format("%.2f", resu?.toDoubleOrNull() ?: 0.0)
        //выводим результат
        number.text = "$n метров"
        resul.text = "$round руб."
    }

    //событие для перехода на первый экран регистрации
    fun onFlatBank(view: View) {
        val intent = Intent(this, FlatBank::class.java)
        startActivity(intent)
    }
}