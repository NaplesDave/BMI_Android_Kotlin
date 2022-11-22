package com.techbyking.sendingdatafromactivitytofragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class BMIFragment : Fragment() {

    lateinit var result : TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // create a view Object for our fragment
        // Inflate the layout for this fragment
        val view :View = inflater.inflate(R.layout.fragment_b_m_i, container, false)

        result = view.findViewById(R.id.textViewResult)

        // check for null value of Bundle object and skip if null or empty
        arguments?.let{
            val weight: Double = arguments?.getInt("weight")!!.toDouble()
            val height: Double = arguments?.getInt("height")!!.toDouble()

            // calculate the bmi in IMPERIAL - U.S. style
            val bmi: Double = (weight / (height * height)) * 703

            // update the screen textView with the bmi value in U.S.
            // format it to show ##.## number
            result.text = "Your BMI is ${"%.2f"}".format(bmi)
        }  // end argument null safety check

        return view
    }

}