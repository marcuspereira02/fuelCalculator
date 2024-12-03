package com.marcuspereira.fuelcalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_ACTIVITY = "ResultActivity.Key"



class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val consumoGasolina: Float = intent.getFloatExtra("CONSUMO_GASOLINA", 0f)
        val precoCombustivel: Float =intent.getFloatExtra("PRECO_COMBUSTIVEL", 0f)
        val distanciaKm: Float = intent.getFloatExtra("DISTANCIA_KM", 0f)

        }
    }
