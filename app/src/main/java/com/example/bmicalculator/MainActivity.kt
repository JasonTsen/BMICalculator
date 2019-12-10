package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            calculateBMI()

        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            reset()

        }
    }
    private fun calculateBMI(){
        val weight: Double = editTextWeight.text.toString().toDouble()
        val height: Double = editTextHeight.text.toString().toDouble()

        var bmi = String.format("%.2f", weight/((height/100)*(height/100)))

        if(bmi.toDouble() < 18.5){

            val underweight : ImageView = findViewById(R.id.imageViewProfile)
            underweight.setImageResource(R.drawable.under)
            textViewBMI.setText("BMI: " + bmi)
        }else if(bmi.toDouble() > 18.5 && bmi.toDouble() < 24.9 ){
            val normal : ImageView = findViewById(R.id.imageViewProfile)
            normal.setImageResource(R.drawable.normal)
            textViewBMI.setText("BMI: " + bmi)
        }else if(bmi.toDouble() > 25){
            val over : ImageView = findViewById(R.id.imageViewProfile)
            over.setImageResource(R.drawable.over)
            textViewBMI.setText("BMI: " + bmi)
        }else{
            val default : ImageView = findViewById(R.id.imageViewProfile)
            default.setImageResource(R.drawable.empty)
        }

    }
    private fun reset(){
        editTextHeight.text = null
        editTextWeight.text = null
        imageViewProfile.setImageResource(R.drawable.empty)
        textViewBMI.text = null
    }
}
