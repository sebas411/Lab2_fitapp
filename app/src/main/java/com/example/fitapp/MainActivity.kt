package com.example.fitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var congratulationsImage:ImageView
    lateinit var vueltasText:TextView
    private var contador=0
    val duration=Toast.LENGTH_SHORT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vueltaButton: Button=findViewById(R.id.button2)
        val reiniciarButton: Button=findViewById(R.id.button3)
        congratulationsImage=findViewById(R.id.imageView)
        vueltasText=findViewById(R.id.textView)
        vueltaButton.setOnClickListener{
            addVuelta()
        }
        vueltaButton.setOnLongClickListener{
            mostrarVueltas()
            return@setOnLongClickListener true
        }
        reiniciarButton.setOnClickListener{
            reiniciar()
        }
    }
    private fun addVuelta(){
        if (contador<20){
            contador++
            vueltasText.setText(Integer.toString(contador))
            if (contador==20){
                Toast.makeText(applicationContext,"¡Felicitaciones! Ha llegado a su objetivo",duration).show()
                congratulationsImage.setImageResource(R.drawable.imagen20)
            }
        }
        if (contador==10){
            Toast.makeText(applicationContext,"Faltan 10 vueltas para el objetivo",duration).show()
            congratulationsImage.setImageResource(R.drawable.imagen10)
            congratulationsImage.visibility= View.VISIBLE
        }
    }
    private fun reiniciar(){
        contador=0
        vueltasText.setText("0")
        congratulationsImage.visibility= View.INVISIBLE
    }
    private fun mostrarVueltas(){
        Toast.makeText(applicationContext,"Faltan "+Integer.toString(20-contador)+" vueltas",duration).show()
    }
}
