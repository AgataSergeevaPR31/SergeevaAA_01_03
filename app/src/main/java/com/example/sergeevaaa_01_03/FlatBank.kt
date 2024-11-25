package com.example.sergeevaaa_01_03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class FlatBank : AppCompatActivity() {
    private lateinit var login: EditText
    private lateinit var pass: EditText

    //корректные логин и пароль, которые должен ввести пользователь для продолжения работы с приложеним
    private val correctLogin = "ects"
    private val correctPassword = "ects2024"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flat_bank)
        login = findViewById<EditText>(R.id.login)
        pass = findViewById<EditText>(R.id.password)
    }

    //событие для перехода на второй экран с функцией расчёта стоимости квартиры
    fun onCalculaterScreen(view: View) {
        //проверка на то, что поля для ввода логина и пароля не пустые
        if (login.text.toString().isNotEmpty() and pass.text.toString().isNotEmpty()) {
            //проверка на то, что пользовател  ввёл корректный логи и пароль
            if (login.text.toString() == correctLogin && pass.text.toString() == correctPassword) {
                //переход на второй экран
                val intent = Intent(this, CalculateScreen::class.java)
                startActivity(intent)
            }
            //вывод сообщения об ошибке, что логин или пароль не верный
            else { Snackbar.make(view,"Неверный логин или пароль", Snackbar.LENGTH_LONG).show()}
        //вывод сообщения об ошибке, что пользователь не заполнил какое-либо поле
        } else {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Есть незаполненые поля!")
                .setPositiveButton("OK", null)
                .create()
                .show()
        }
    }
}