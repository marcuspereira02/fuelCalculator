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
import com.google.android.material.textfield.TextInputLayout

const val KEY_PRICE_ACTIVITY =  "PriceActivity.Key"

class PriceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_price)

        val btn_Proximo = findViewById<Button>(R.id.btn_Proximo1)
        val it_Preco = findViewById<TextInputEditText>(R.id.it_Preco_Gasolina)

        btn_Proximo.setOnClickListener {
            val precoStr:String = it_Preco.text.toString()

            if (precoStr == "" ) {
                Snackbar.make(it_Preco, "Preencha todos os campos", Snackbar.LENGTH_LONG).show()
            }else{
                val preco_Gasolina : Float = it_Preco.text.toString().toFloat()
                val intent = Intent(this, ConsumptionActivity::class.java)

                intent.putExtra(KEY_CONSUMPTION_ACTIVITY, preco_Gasolina)
                startActivity(intent)
                }
            }
        }
    }