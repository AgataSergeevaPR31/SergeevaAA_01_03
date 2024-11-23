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
        val apartment = spinner.selectedItem
        val numb = number.text.toString().toIntOrNull()

        if (numb != null) {
            if (numb >= 1) {
                val count : Double = 100.0
                var res : Double = 0.0
                val choose: String = apartment.toString()

                when (choose) {
                    "1. 1-комнатная квартира" -> { if (numb >= 28 && numb <= 38) res = numb * 1.4 * count
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

                var round = String.format("%.2f", res)
                result.setText("$round метров")

                Handler().postDelayed({
                    intent.putExtra("result", res.toString())
                    intent.putExtra("number", numb.toString())
                    val intent = Intent(this, ResultScreen::class.java)

                    startActivity(intent)
                }, 3000)

            }
            else result.text = "Нет у вас квартиры!"
        }
        else {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Введите количество метров!")
                .setPositiveButton("OK", null)
                .create()
                .show()
        }

    }
}