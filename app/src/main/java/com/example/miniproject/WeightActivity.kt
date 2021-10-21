package com.example.miniproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.inputmethod.EditorInfo
import android.widget.*

class WeightActivity : AppCompatActivity() {
    private lateinit var mTextType: TextView
    private lateinit var mEditinput: EditText
    private lateinit var mTextg: TextView
    private lateinit var mTextkg: TextView
    private lateinit var mTextton: TextView
    private lateinit var mTextlb: TextView
    private lateinit var mTextoz: TextView
    private lateinit var mButton: Button
    private lateinit var mSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)
        mButton = findViewById(R.id.weight_button)
        mTextType = findViewById(R.id.textViewType)
        mEditinput = findViewById(R.id.editTextinput)
        mSpinner = findViewById(R.id.spinnerUnits)
        mTextg = findViewById(R.id.TextViewg)
        mTextkg = findViewById(R.id.TextViewkg)
        mTextton = findViewById(R.id.TextViewton)
        mTextlb = findViewById(R.id.TextViewlb)
        mTextoz = findViewById(R.id.TextViewoz)

        val weight_item = arrayOf("Grams","Kilograms","Ton","lbs","Oz")
        val adapter = ArrayAdapter(baseContext, android.R.layout.simple_spinner_dropdown_item, weight_item)
        mSpinner.adapter = adapter

        findViewById<Button>(R.id.weight_button).apply {//Button
            setOnClickListener {
                converter()
            }
        }
    }

    private fun converter(){
        val weight_str = mEditinput.getText().toString()
        if(weight_str.isEmpty()){
            toast("Empty Field")
            mEditinput.setError("Please fill the number")
            mTextg.setText("")
            mTextkg.setText("")
            mTextton.setText("")
            mTextlb.setText("")
            mTextoz.setText("")

        }else {
            if(mSpinner.selectedItem == "Grams"){
                val input = weight_str.toDouble()

                val grams = String.format("%.2f",input)
                val kg = String.format("%.2f",input/1000)
                val ton = String.format("%.7f",input/1000000)
                val lbs = String.format("%.2f",input/453.59)
                val oz = String.format("%.2f",input/28.35)

                mTextg.setText(""+grams)
                mTextkg.setText(""+kg)
                mTextton.setText(""+ton)
                mTextlb.setText(""+lbs)
                mTextoz.setText(""+oz)
            }
            if(mSpinner.selectedItem == "Kilograms"){
                val input = weight_str.toDouble()

                val grams = String.format("%.2f",input*1000)
                val kg = String.format("%.2f",input)
                val ton = String.format("%.3f",input*0.001)
                val lbs = String.format("%.2f",input*2.204)
                val oz = String.format("%.2f",input*35.273)

                mTextg.setText(""+grams)
                mTextkg.setText(""+kg)
                mTextton.setText(""+ton)
                mTextlb.setText(""+lbs)
                mTextoz.setText(""+oz)
            }
            if(mSpinner.selectedItem == "Ton"){
                val input = weight_str.toDouble()

                val grams = String.format("%.2f",input*1000000)
                val kg = String.format("%.2f",input*1000)
                val ton = String.format("%.2f",input)
                val lbs = String.format("%.2f",input*2204.62) //0.000453
                val oz = String.format("%.2f",input*35273.961)

                mTextg.setText(""+grams)
                mTextkg.setText(""+kg)
                mTextton.setText(""+ton)
                mTextlb.setText(""+lbs)
                mTextoz.setText(""+oz)
            }
            if(mSpinner.selectedItem == "lbs"){
                val input = weight_str.toDouble()

                val grams = String.format("%.2f",input*453.592)
                val kg = String.format("%.2f",input*0.45)
                val ton = String.format("%.3f",input*0.000453)
                val lbs = String.format("%.2f",input)
                val oz = String.format("%.2f",input*16)

                mTextg.setText(""+grams)
                mTextkg.setText(""+kg)
                mTextton.setText(""+ton)
                mTextlb.setText(""+lbs)
                mTextoz.setText(""+oz)
            }
            if(mSpinner.selectedItem == "Oz"){
                val input = weight_str.toDouble()

                val grams = String.format("%.2f",input*28.349)
                val kg = String.format("%.2f",input*0.03)
                val ton = String.format("%.6f",input*0.0000283495231)
                val lbs = String.format("%.3f",input*0.0625)
                val oz = String.format("%.2f",input)

                mTextg.setText(""+grams)
                mTextkg.setText(""+kg)
                mTextton.setText(""+ton)
                mTextlb.setText(""+lbs)
                mTextoz.setText(""+oz)
            }
            if (weight_str.toDouble() == 0.0) {
                toast("Please Enter number more than 0")
                mEditinput.setError("Enter the number more than 0")
                mTextg.setText("")
                mTextkg.setText("")
                mTextton.setText("")
                mTextlb.setText("")
                mTextoz.setText("")
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










