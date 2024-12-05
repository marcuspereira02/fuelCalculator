package com.marcuspereira.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_MAIN_ACTIVITY = "MainActivity.Key"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
            val btnIniciar = findViewById<Button>(R.id.btn_iniciar)

            btnIniciar.setOnClickListener{
               val intent = Intent(this, PriceActivity::class.java)
               intent.putExtra(KEY_PRICE_ACTIVITY,"")
                startActivity(intent)
            }
        }
    }