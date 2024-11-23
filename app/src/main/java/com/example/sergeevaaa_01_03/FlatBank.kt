package com.example.sergeevaaa_01_03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class FlatBank : AppCompatActivity() {
    private lateinit var login: EditText
    private lateinit var pass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flat_bank)
        login = findViewById<EditText>(R.id.login)
        pass = findViewById<EditText>(R.id.password)
    }

    fun onCalculaterScreen(view: View) {
        if (login.text.toString().isNotEmpty() and pass.text.toString().isNotEmpty()) {
            val intent = Intent(this, CalculateScreen::class.java)
            startActivity(intent)
        } else {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Введите логин и пароль!")
                .setPositiveButton("OK", null)
                .create()
                .show()
        }
    }
}