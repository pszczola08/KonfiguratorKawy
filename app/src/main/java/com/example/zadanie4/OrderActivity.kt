package com.example.zadanie4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.order)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val coffee = intent.getStringExtra("coffee")
        val sugar = if(intent.getBooleanExtra("sugar", true)) "Tak" else "Nie"
        val count = intent.getStringExtra("count")

        val textCoffee = findViewById<TextView>(R.id.text_coffee)
        val textSugar = findViewById<TextView>(R.id.text_sugar)
        val textCount = findViewById<TextView>(R.id.text_count)

        textCoffee.text = "Wybrana Kawa: $coffee"
        textSugar.text = "Cukier? $sugar"
        textCount.text = "Ilość Kaw: $count"
    }
}