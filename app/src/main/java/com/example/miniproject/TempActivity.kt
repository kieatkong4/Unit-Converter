package com.example.miniproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.inputmethod.EditorInfo
import android.widget.*

class TempActivity : AppCompatActivity() {
    private lateinit var mTextType: TextView
    private lateinit var mEditinput: EditText
    private lateinit var mTextc: TextView
    private lateinit var mTextf: TextView
    private lateinit var mTextk: TextView
    private lateinit var mButton: Button
    private lateinit var mSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp)
        mButton = findViewById(R.id.temp_button)
        mTextType = findViewById(R.id.textViewType)
        mEditinput = findViewById(R.id.editTextinput)
        mSpinner = findViewById(R.id.spinnerUnits)
        mTextc = findViewById(R.id.TextViewCelsius)
        mTextf = findViewById(R.id.TextViewFahrenheit)
        mTextk = findViewById(R.id.TextViewKelvin)


        val temp_item = arrayOf("Celsius","Fahrenheit","Kelvin")
        val adapter = ArrayAdapter(baseContext, android.R.layout.simple_spinner_dropdown_item, temp_item)
        mSpinner.adapter = adapter

        findViewById<Button>(R.id.temp_button).apply {//Button
            setOnClickListener {
                converter()
            }
        }
    }

    private fun converter(){
        val temp_str = mEditinput.getText().toString()

        if(temp_str.isEmpty()){
            toast("Empty Field")
            mEditinput.setError("Please fill the number")
            mTextc.setText("")
            mTextf.setText("")
            mTextk.setText("")


        }else {
            if(mSpinner.selectedItem == "Celsius"){
                val input = temp_str.toDouble()

                val c = String.format("%.2f",input)
                val f = String.format("%.2f",input*33.8)
                val k = String.format("%.2f",input*274.15)

                mTextc.setText(""+c)
                mTextf.setText(""+f)
                mTextk.setText(""+k)
            }
            if(mSpinner.selectedItem == "Fahrenheit"){
                val input = temp_str.toDouble()

                val c = String.format("%.2f",input*(-17.2222222))
                val f = String.format("%.2f",input)
                val k = String.format("%.2f",input*255.927778)

                mTextc.setText(""+c)
                mTextf.setText(""+f)
                mTextk.setText(""+k)
            }
            if(mSpinner.selectedItem == "Kelvin"){
                val input = temp_str.toDouble()

                val c = String.format("%.2f",input*(-272.15))
                val f = String.format("%.2f",input*(-457.87))
                val k = String.format("%.2f",input)

                mTextc.setText(""+c)
                mTextf.setText(""+f)
                mTextk.setText(""+k)
            }
            if (temp_str.toDouble() == 0.0) {
                if (mSpinner.selectedItem == "Celsius") {
                    mTextc.setText("0")
                    mTextf.setText("32")
                    mTextk.setText("273.15")
                }
                if (mSpinner.selectedItem == "Fahrenheit") {
                    mTextc.setText("-17.78")
                    mTextf.setText("0")
                    mTextk.setText("255.37")
                }
                if (mSpinner.selectedItem == "Kelvin") {
                    mTextc.setText("-273.15")
                    mTextf.setText("-459.67")
                    mTextk.setText("0")
                }
                return
            }
        }

        //ซ่อนคีย์บอร์ด
        mEditinput.onEditorAction(EditorInfo.IME_ACTION_DONE)
    }

    private fun toast(msg: String) {
        val t = Toast.makeText(this, msg, Toast.LENGTH_LONG)
        t.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 650)
        //t.view.background.colorFilter = PorterDuffColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN)
        // t.view.findViewById<TextView>(android.R.id.message).setTextColor(Color.WHITE)
        t.show()
    }
}