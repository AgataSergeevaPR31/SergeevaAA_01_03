package com.example.sergeevaaa_01_03

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class CalculateScreen : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var number: EditText
    private lateinit var result: TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_screen)
        spinner = findViewById(R.id.spinner)
        number = findViewById(R.id.number)
        result = findViewById(R.id.result)
    }

    fun onResultScreen(view: View) {
        //берем выбранное значение в спиннере
        val apartment = spinner.selectedItem
        //берем значение, которе ввёл пользователь
        val numb = number.text.toString().toIntOrNull()

        //проверка на то, что поле для ввода метров не пустое
        if (numb != null) {
            if (numb >= 1) {
                val count : Double = 100.0
                var res : Double = 0.0
                val choose: String = apartment.toString()

                //смотри,что выбрал пользователь в спиннере
                when (choose) {
                    "1. 1-комнатная квартира" -> { if (numb >= 28 && numb <= 38) res = numb * 1.4 * count
                    //вывод сообщения о том, что пользователь ввёл некорректное количество метров для выбранной квартиры
                    else {val alert = AlertDialog.Builder(this)
                        .setTitle("Ошибка")
                        .setMessage("Неподходящее кол-во метров для 1-комнатной кв.!")
                        .setPositiveButton("OK", null)
                        .create()
                        .show()}}
                    "2. 2-комнатная квартира" -> { if (numb >= 39 && numb <= 53 ) res = numb * count
                    else {val alert = AlertDialog.Builder(this)
                        .setTitle("Ошибка")
                        .setMessage("Неподходящее кол-во метров для 2-комнатной кв.!")
                        .setPositiveButton("OK", null)
                        .create()
                        .show()}}
                    "3. 3-комнатная квартира" -> {if (numb >= 54 && numb <= 65) res = numb * 0.8 * count
                    else {val alert = AlertDialog.Builder(this)
                        .setTitle("Ошибка")
                        .setMessage("Неподходящее кол-во метров для 3-комнатной кв.!")
                        .setPositiveButton("OK", null)
                        .create()
                        .show()}}
                    "4. Студия" -> {if (numb >= 19 && numb <= 27) res = numb * 1.1 * count
                    else {val alert = AlertDialog.Builder(this)
                        .setTitle("Ошибка")
                        .setMessage("Неподходящее кол-во метров для кв. студии!")
                        .setPositiveButton("OK", null)
                        .create()
                        .show()}}
                    else -> res = 0.0
                }

                //округляем и выводим результат
                var round = String.format("%.2f", res)
                result.setText("$round метров")

                //переход на третий экран с результатом с задержкой в 3 секунды
                Handler().postDelayed({

                    val intent = Intent(this, ResultScreen::class.java)
                    //передаем на третий экран данные
                    intent.putExtra("result", res.toString())
                    intent.putExtra("number", numb.toString())
                    startActivity(intent)
                }, 3000)

            }
            //вывод в поле с результатом сообщения о том, что пользователь ввёл нулевое значение
            else result.text = "Нет у вас квартиры!"
        }
        else {
            //вывод сообщения о том, что пользователь не ввёл кол-во метров в квартире
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Введите количество метров!")
                .setPositiveButton("OK", null)
                .create()
                .show()
        }

    }

    //событие для перехода на первый экран регистрации
    fun onFlatScreen(view: View) {
        val intent = Intent(this, FlatBank::class.java)
        startActivity(intent)
    }
}