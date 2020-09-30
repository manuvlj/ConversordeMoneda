package com.manudavid.conversordemoneda

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object{
        private const val EMPTY = ""
    }

    @SuppressLint("StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         convertir_button.setOnClickListener{
             var resultado:Double = 0.0
             var cantidad = cantidad_editTextNumber.text.toString().toDoubleOrNull()
             val deMoneda = desde_spinner.selectedItem.toString()
             val aMoneda = a_spinner.selectedItem.toString()

             if(cantidad == null  || deMoneda == EMPTY || aMoneda == EMPTY){
                 resultado_text.setText("Usted no ingresó todos los datos")
             }

             else{

                     if (deMoneda == "COP") {
                         resultado = cantidad*(1)
                         if(aMoneda == "Dolar"){
                             resultado = cantidad*(0.00027)
                         }

                         if(aMoneda == "Euro"){
                             resultado = cantidad*(0.00023)
                         }
                     }

                 if (deMoneda == "Dolar") {
                     resultado = cantidad*(1)
                     if(aMoneda == "COP"){
                         resultado = cantidad*(3788.5)
                     }

                     if(aMoneda == "Euro"){
                         resultado = cantidad*(0.85)
                     }
                 }

                 if (deMoneda == "Euro") {
                     resultado = cantidad*(1)
                     if(aMoneda == "Dolar"){
                         resultado = cantidad*(1.18)
                     }

                     if(aMoneda == "COP"){
                         resultado = cantidad*(4457.06)
                     }
                 }

             }

             resultado_text.text = resultado.toString()
             //resultado_text.text = resources.getString(R.string.conversion, resultado)
         }

    }
}