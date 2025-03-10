package com.example.zadanie4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val coffee = findViewById<Spinner>(R.id.coffee_spinner)
        val sugar = findViewById<CheckBox>(R.id.sugar_checkbox)
        val count = findViewById<SeekBar>(R.id.count)
        val countText = findViewById<TextView>(R.id.countText)
        val mainCoffeeImage = findViewById<ImageView>(R.id.main_coffee_image)
        val SubmitBtn = findViewById<Button>(R.id.btn_submit)
        count.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                countText.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) { }
            override fun onStopTrackingTouch(seekBar: SeekBar?) { }
        })
        val typeImages = listOf(
            R.drawable.szablon,
            R.drawable.espresso,
            R.drawable.americano,
            R.drawable.latte,
            R.drawable.capuccino,
            R.drawable.flatwhite,
            R.drawable.macciato,
            R.drawable.mocca
        )
        coffee.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                mainCoffeeImage.setImageResource(typeImages[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) { }
        }

        SubmitBtn.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }
    }
}