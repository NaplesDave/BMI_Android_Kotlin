# BMI_Android_Kotlin
BMI calculator for ANDROID KOTLIN.
Udemy course: 
Android App Development with KOTLIN | Beginner to Advanced
// Oak Academy project - BMI Calculator - Section 20
// Modified by: David King Nov 21, 2022
Changed Calculation for U.S. Imperial in LBS and INCHES
Added checkes for Valid values ntered or Toast message pops up telling user to enter valid values
Wrapped the calculate.setOnClickListener in MainActivity.kt in a TRY- CATCH to catch errors and stop program from crashing
Added NULL SAFETY check in BMIFragment.kt file to check the data Bundle object for NULL state.
If the Bundle object did not pass the extra data for some reason the program won't crash.
That procedure will bypass.
