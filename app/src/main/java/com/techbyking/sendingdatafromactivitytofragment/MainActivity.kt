package com.techbyking.sendingdatafromactivitytofragment
// UDEMY course
// Android App Development with KOTLIN | Beginner to Advanced
// Oak Academy project - BMI Calculator - Section 20
// Modified by: David King Nov 21, 2022
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.Validators.or
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    lateinit var etWeight : EditText
    lateinit var etHeight : EditText
    lateinit var calculate : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // hook up the vars to the view elements
        etWeight = findViewById(R.id.editTextWeight)
        etHeight = findViewById(R.id.editTextHeight)
        calculate = findViewById(R.id.buttonCalculate)

        // Create the Fragment hook up stuff
        val fm : FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = fm.beginTransaction()
        // create a BMIFragment object named bmiFragment
        val bmiFragment = BMIFragment()

        calculate.setOnClickListener {
            // wrap the section in a try-catch so bad entries won't crash the
            // program.
            try{
        // get the data from the screen views and store them here
        val weight = etWeight.text.toString().toInt()
        val height = etHeight.text.toString().toInt()

        // check entries for fair values
        if ((weight <= 0) || (weight > 500))  {
            throw Exception("weight is not in normal range")
        }
        if ((height <= 10) || (height > 100))  {
            throw Exception("weight is not in normal range")
        }

        // create a new Bundle object to pass the data
        val bundle = Bundle()
        bundle.putInt("weight", weight)
        bundle.putInt("height", height)

        // bind the bundle as a parameter for the bmiFragment creation
        bmiFragment.arguments = bundle

        // set up the fragment transaction
            // where to send the fragment, what fragment name
            ft.add(R.id.frame, bmiFragment)

        // show the fragment in the frame in th MainActivity
            ft.commit()


        } // end calculate button onClickListener
            // catch an entry error and display a message to the user
            catch (e : Exception){
            Toast.makeText(applicationContext, "Please enter valid values for" +
                    " both numbers.", Toast.LENGTH_LONG).show()}
        }

    } // end onCreate function

} // end MainActivity