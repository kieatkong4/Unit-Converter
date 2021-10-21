package com.example.miniproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.inputmethod.EditorInfo
import android.widget.*

class LengthActivity2 : AppCompatActivity() {
    private lateinit var mTextType: TextView
    private lateinit var mEditinput: EditText
    private lateinit var mTextmm: TextView
    private lateinit var mTextcm: TextView
    private lateinit var mTextm: TextView
    private lateinit var mTextkm: TextView
    private lateinit var mTextinch: TextView
    private lateinit var mTextft: TextView
    private lateinit var mTextmile: TextView
    private lateinit var mButton: Button
    private lateinit var mSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_length2)
        mButton = findViewById(R.id.length_button)
        mTextType = findViewById(R.id.textViewType)
        mEditinput = findViewById(R.id.editTextinput)
        mSpinner = findViewById(R.id.spinnerUnits)
        mTextmm = findViewById(R.id.TextViewmm)
        mTextcm = findViewById(R.id.TextViewcm)
        mTextm = findViewById(R.id.TextViewm)
        mTextkm = findViewById(R.id.TextViewkm)
        mTextinch = findViewById(R.id.TextViewinch)
        mTextft = findViewById(R.id.TextViewft)
        mTextmile = findViewById(R.id.TextViewmile)

        val length_item = arrayOf("Milimeters","Centimeters","Meters","Kilometers","Inches","Feets","Miles")
        val adapter = ArrayAdapter(baseContext, android.R.layout.simple_spinner_dropdown_item, length_item)
        mSpinner.adapter = adapter

        findViewById<Button>(R.id.length_button).apply {//Button
            setOnClickListener {
                converter()
            }
        }
    }
    private fun converter(){
        val length_str = mEditinput.getText().toString()

        if(length_str.isEmpty()){
            toast("Empty Field")
            mEditinput.setError("Please fill the number")
            mTextmm.setText("")
            mTextcm.setText("")
            mTextm.setText("")
            mTextkm.setText("")
            mTextinch.setText("")
            mTextft.setText("")
            mTextmile.setText("")

        }else {
            if(mSpinner.selectedItem == "Milimeters"){
                val input = length_str.toDouble()

                val mm = String.format("%.2f",input)
                val cm = String.format("%.2f",input*0.1)
                val m = String.format("%.2f",input*0.001)
                val km = String.format("%.2f",input*0.000001)
                val inch = String.format("%.2f",input*0.03937)
                val ft = String.format("%.2f",input*0.00328)
                val mile = String.format("%.2f",input*0.0000006213)

                mTextmm.setText(""+mm)
                mTextcm.setText(""+cm)
                mTextm.setText(""+m)
                mTextkm.setText(""+km)
                mTextinch.setText(""+inch)
                mTextft.setText(""+ft)
                mTextmile.setText(""+mile)
            }
            if(mSpinner.selectedItem == "Centimeters"){
                val input = length_str.toDouble()

                val mm = String.format("%.2f",input*10)
                val cm = String.format("%.2f",input)
                val m = String.format("%.2f",input*0.01)
                val km = String.format("%.2f",input*0.00001)
                val inch = String.format("%.2f",input*0.393700787)
                val ft = String.format("%.2f",input*0.032808)
                val mile = String.format("%.2f",input*0.0000062137)

                mTextmm.setText(""+mm)
                mTextcm.setText(""+cm)
                mTextm.setText(""+m)
                mTextkm.setText(""+km)
                mTextinch.setText(""+inch)
                mTextft.setText(""+ft)
                mTextmile.setText(""+mile)
            }
            if(mSpinner.selectedItem == "Meters") {
                val input = length_str.toDouble()

                val mm = String.format("%.2f", input * 1000)
                val cm = String.format("%.2f", input * 100 )
                val m = String.format("%.2f", input)
                val km = String.format("%.2f", input * 0.001)
                val inch = String.format("%.2f", input * 39.37000787)
                val ft = String.format("%.2f", input * 3.2808399)
                val mile = String.format("%.2f", input * 0.000621371192)

                mTextmm.setText("" + mm)
                mTextcm.setText("" + cm)
                mTextm.setText("" + m)
                mTextkm.setText("" + km)
                mTextinch.setText("" + inch)
                mTextft.setText("" + ft)
                mTextmile.setText("" + mile)
            }
            if(mSpinner.selectedItem == "Kilometers"){
                val input = length_str.toDouble()

                val mm = String.format("%.2f",input*1000000)
                val cm = String.format("%.2f",input*100000)
                val m = String.format("%.2f",input*1000)
                val km = String.format("%.2f",input)
                val inch = String.format("%.2f",input*39370.0787)
                val ft = String.format("%.2f",input*3280.8399)
                val mile = String.format("%.2f",input*0.621371192)

                mTextmm.setText(""+mm)
                mTextcm.setText(""+cm)
                mTextm.setText(""+m)
                mTextkm.setText(""+km)
                mTextinch.setText(""+inch)
                mTextft.setText(""+ft)
                mTextmile.setText(""+mile)
            }
            if(mSpinner.selectedItem == "Inches"){
                val input = length_str.toDouble()

                val mm = String.format("%.2f",input*25.4)
                val cm = String.format("%.2f",input*2.54)
                val m = String.format("%.2f",input*0.0254)
                val km = String.format("%.2f",input*0.0000254)
                val inch = String.format("%.2f",input)
                val ft = String.format("%.2f",input*0.0833333333)
                val mile = String.format("%.2f",input*0.0000157828283)

                mTextmm.setText(""+mm)
                mTextcm.setText(""+cm)
                mTextm.setText(""+m)
                mTextkm.setText(""+km)
                mTextinch.setText(""+inch)
                mTextft.setText(""+ft)
                mTextmile.setText(""+mile)
            }
            if(mSpinner.selectedItem == "Feets"){
                val input = length_str.toDouble()

                val mm = String.format("%.2f",input*304.8)
                val cm = String.format("%.2f",input*30.48)
                val m = String.format("%.2f",input*0.3048)
                val km = String.format("%.2f",input*0.0003048)
                val inch = String.format("%.2f",input*12)
                val ft = String.format("%.2f",input)
                val mile = String.format("%.2f",input*0.000189393939)

                mTextmm.setText(""+mm)
                mTextcm.setText(""+cm)
                mTextm.setText(""+m)
                mTextkm.setText(""+km)
                mTextinch.setText(""+inch)
                mTextft.setText(""+ft)
                mTextmile.setText(""+mile)
            }
            if(mSpinner.selectedItem == "Miles"){
                val input = length_str.toDouble()

                val mm = String.format("%.2f",input*1609344)
                val cm = String.format("%.2f",input*160934.4)
                val m = String.format("%.2f",input*1609.344)
                val km = String.format("%.2f",input*1.609344)
                val inch = String.format("%.2f",input*63360)
                val ft = String.format("%.2f",input*5280)
                val mile = String.format("%.2f",input)

                mTextmm.setText(""+mm)
                mTextcm.setText(""+cm)
                mTextm.setText(""+m)
                mTextkm.setText(""+km)
                mTextinch.setText(""+inch)
                mTextft.setText(""+ft)
                mTextmile.setText(""+mile)
            }
            if (length_str.toDouble() == 0.0) {
                toast("Please Enter number more than 0")
                mEditinput.setError("Enter the number more than 0")
                mTextmm.setText("")
                mTextcm.setText("")
                mTextm.setText("")
                mTextkm.setText("")
                mTextinch.setText("")
                mTextft.setText("")
                mTextmile.setText("")
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