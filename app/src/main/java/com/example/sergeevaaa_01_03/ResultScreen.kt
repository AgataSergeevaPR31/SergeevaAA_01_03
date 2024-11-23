package com.example.sergeevaaa_01_03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ResultScreen : AppCompatActivity() {
    private lateinit var number : TextView
    private lateinit var resul : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)
        number = findViewById(R.id.numb)
        resul = findViewById(R.id.result)

        var resu = intent.getStringExtra("result")
        var n = intent.getStringExtra("number")
        var round = String.format("%.2f", resu)
        number.text = n + " метров"
        resul.setText("$round руб.");
    }

    fun onFlatBank(view: View) {
        val intent = Intent(this, FlatBank::class.java)
        startActivity(intent)
    }
}