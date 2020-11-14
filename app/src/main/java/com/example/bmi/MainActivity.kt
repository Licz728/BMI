package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

// variable : Type
// val = value, variable
//E.g val pi : Double = 3.14159 or val pi = 3.14159
//E.g number : Float

class MainActivity : AppCompatActivity() {
    //Global variable
    //val = value, var = variable
    private val intCount = 10
    //Lateinit = Late initialize
    //private = access modifier
    private lateinit var editTextWeight: EditText
    private lateinit var editTextHeight: EditText
    private lateinit var textViewBMI: TextView
    private lateinit var imageViewBMI: ImageView
    private lateinit var imageViewMoreInfo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Display the UI
        //R = resources class (res/ folder)
        setContentView(R.layout.activity_main)
        //Link UI to program
        editTextWeight= findViewById(R.id.editTextWeight)
        editTextHeight = findViewById(R.id.editTextHeight)
        imageViewBMI = findViewById(R.id.imageView)
        textViewBMI = findViewById(R.id.textViewBMI)
        imageViewMoreInfo = findViewById(R.id.imageViewMoreInfo)

        imageViewMoreInfo.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }

        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        buttonCalculate.setOnClickListener {
            //To retrieve value from a view
            val weight: Float = editTextWeight.text.toString().toFloat()
            val height: Float = editTextHeight.text.toString().toFloat()

            //BMI = kg/m pow 2
            val bmi = weight/(height/100).pow(2)

            //TODO: Determine the status of BMI and present the result to the user
            //Underweight = 18.5
            //Normal weight = 18.5-24.9
            //OverWeight = 25
            if (bmi <= 18.5) {
                textViewBMI.text = "BMI : ${bmi.toString()}, Status : ${getString(R.string.underweight)}"
                imageViewBMI.setImageResource(R.drawable.under)
            }
            else if (bmi <= 24.9 ) {
                textViewBMI.text = String.format("%1.2f, %s", bmi, getString(R.string.normal))
                imageViewBMI.setImageResource(R.drawable.normal)
            }
            else {
                textViewBMI.text = "BMI : ${bmi.toString()}, Status : ${getString(R.string.overweight)}"
                imageViewBMI.setImageResource(R.drawable.over)
            }
        }//end of onClickListener

        val buttonReset: Button = findViewById(R.id.buttonReset)
        buttonReset.setOnClickListener {
            editTextWeight.text = null
            editTextHeight.text.clear()   //clear text for EditText
            textViewBMI.text = ""         //clear text for TextView
            imageViewBMI.setImageResource(R.drawable.empty)
        }
    }//end of function
}//end of class