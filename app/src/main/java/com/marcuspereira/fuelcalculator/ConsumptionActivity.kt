package com.marcuspereira.fuelcalculator

import android.content.Intent
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val  KEY_CONSUMPTION_ACTIVITY = "ConsumptionActivity.Key"

class ConsumptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumption)

        val precoCombustivel: Float =intent.getFloatExtra("PRECO_COMBUSTIVEL", 0f)
        val btnProximo2 = findViewById<Button>(R.id.btn_Proximo2)
        val itConsumo = findViewById<TextInputEditText>(R.id.it_Consumo)

        btnProximo2.setOnClickListener {
            val consumoStr : String = itConsumo.text.toString()
            if (consumoStr == ""){
                Snackbar.make(itConsumo, "Preencha todos os campos", Snackbar.LENGTH_LONG).show()
            } else {
                val consumoGasolina : Float = itConsumo.text.toString().toFloat()

                val intent = Intent(this, DistanceActivity::class.java)
                intent.putExtra(KEY_DISTANCE_ACTIVITY, consumoGasolina)

                intent.putExtra("PRECO_COMBUSTIVEL", precoCombustivel)
                intent.putExtra("CONSUMO_GASOLINA", consumoGasolina)

                startActivity(intent)
            }
        }
    }
}