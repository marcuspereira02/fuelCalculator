package com.marcuspereira.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_DISTANCE_ACTIVITY = "DistanceActivity.Key"

class DistanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distance)

        val consumoGasolina: Float = intent.getFloatExtra("CONSUMO_GASOLINA", 0f)
        val precoCombustivel: Float =intent.getFloatExtra("PRECO_COMBUSTIVEL", 0f)
        val btnProximo3 = findViewById<Button>(R.id.btn_Proximo3)
        val itDistance = findViewById<TextInputEditText>(R.id.it_Distancia)

        btnProximo3.setOnClickListener {
            val distanceStr : String = itDistance.text.toString()

            if (distanceStr == ""){
                Snackbar.make(itDistance, "Preencha todos os campos", Snackbar.LENGTH_LONG).show()
            }else{
                val distanceKm : Float = itDistance.text.toString().toFloat()

                val result : Float = (distanceKm / consumoGasolina) * precoCombustivel

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_ACTIVITY, result)

                intent.putExtra("CONSUMO_GASOLINA", consumoGasolina)
                intent.putExtra("PRECO_COMBUSTIVEL", precoCombustivel)
                intent.putExtra("DISTANCIA_KM", distanceKm)

                startActivity(intent)
            }
        }
    }
}
