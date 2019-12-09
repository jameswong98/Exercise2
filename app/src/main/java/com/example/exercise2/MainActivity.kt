package com.example.exercise2

import android.graphics.Picture
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var  Picture : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Picture = findViewById(R.id.imageViewProfile)

        val cal: Button = findViewById(R.id.buttonCalculate)

        cal.setOnClickListener {calculate()}



        val rst: Button = findViewById(R.id.buttonReset)

        rst.setOnClickListener {reset()}
    }

    private fun calculate(){

        val height: EditText = findViewById(R.id.editTextHeight)

        val weight: EditText = findViewById(R.id.editTextWeight)



        val BMIresult = weight.text.toString().toDouble() / ((height.text.toString().toDouble()/100)*(height.text.toString().toDouble()/100))



        textViewBMI.text = BMIresult.toString()







        if(BMIresult < 18.5){

            val underr = BMIresult

            val BMI = when(BMIresult){

                underr -> R.drawable.under

                else -> R.drawable.empty

            }

            Picture.setImageResource(BMI)

            Toast.makeText(this, "You're too skinny!",

                Toast.LENGTH_SHORT).show()

        }else if(BMIresult >= 18.5 && BMIresult <=24.9){

            val norm = BMIresult

            val BMI = when(BMIresult){

                norm -> R.drawable.normal

                else -> R.drawable.empty

            }

            Picture.setImageResource(BMI)

            Toast.makeText(this, "Awesome!",

                Toast.LENGTH_SHORT).show()

        }else if( BMIresult > 25){

            val overr = BMIresult

            val BMI = when(BMIresult){

                overr -> R.drawable.over

                else -> R.drawable.empty

            }

            Picture.setImageResource(BMI)

            Toast.makeText(this, "Let's go to the gym bro!",

                Toast.LENGTH_SHORT).show()

        }

    }



    private fun reset(){

        val height: EditText = findViewById(R.id.editTextHeight)
        height.text = null

        val weight: EditText = findViewById(R.id.editTextWeight)
        weight.text = null


        val bmi: TextView = findViewById(R.id.textViewBMI)
        bmi.text = null

        val Picture: ImageView = findViewById(R.id.imageViewProfile)

        Picture.setImageResource( R.drawable.empty)









    }
}
