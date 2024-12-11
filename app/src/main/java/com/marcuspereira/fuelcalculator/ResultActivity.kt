package com.marcuspereira.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_ACTIVITY = "ResultActivity.Key"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val consumoGasolina: Float = intent.getFloatExtra("CONSUMO_GASOLINA", 0f)
        val precoCombustivel: Float = intent.getFloatExtra("PRECO_COMBUSTIVEL", 0f)
        val distanciaKm: Float = intent.getFloatExtra("DISTANCIA_KM", 0f)
        val result: Float = intent.getFloatExtra(KEY_RESULT_ACTIVITY, 0f)

        val tvResultado = findViewById<TextView>(R.id.tv_Resultado)
        val tvPreco = findViewById<TextView>(R.id.tv_dadoPreco)
        val tvConsumo = findViewById<TextView>(R.id.tv_dadoConsumo)
        val tvKm = findViewById<TextView>(R.id.tv_dadoKm)
        val btnNovoCalculo = findViewById<Button>(R.id.btn_NovoCalculo)

        tvPreco.text = precoCombustivel.toString()
        tvConsumo.text = consumoGasolina.toString()
        tvKm.text = distanciaKm.toString()
        tvResultado.text = String.format("%.2f",result)

        btnNovoCalculo.setOnClickListener {
            val intent = Intent(this, PriceActivity::class.java)
            intent.putExtra(KEY_PRICE_ACTIVITY,"")
            startActivity(intent)
        }
    }
}
