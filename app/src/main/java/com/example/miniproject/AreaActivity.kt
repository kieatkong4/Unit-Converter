package com.example.miniproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.inputmethod.EditorInfo
import android.widget.*

class AreaActivity : AppCompatActivity() {
    private lateinit var mTextType: TextView
    private lateinit var mEditinput: EditText
    private lateinit var mTextrai: TextView
    private lateinit var mTextnagn: TextView
    private lateinit var mTextsquarewa: TextView
    private lateinit var mTextsquarem: TextView
    private lateinit var mTextsquarekm: TextView
    private lateinit var mButton: Button
    private lateinit var mSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_area)

        mButton = findViewById(R.id.area_button)
        mTextType = findViewById(R.id.textViewType)
        mEditinput = findViewById(R.id.editTextinput)
        mSpinner = findViewById(R.id.spinnerUnits)
        mTextrai = findViewById(R.id.TextViewrai)
        mTextnagn = findViewById(R.id.TextViewngan)
        mTextsquarewa = findViewById(R.id.TextViewsquarewa)
        mTextsquarem = findViewById(R.id.TextViewsquarem)
        mTextsquarekm = findViewById(R.id.TextViewsquarekm)

        val area_item = arrayOf("Rai","Ngan","Square Wa","Square Meters","Square Kilometers")
        val adapter = ArrayAdapter(baseContext, android.R.layout.simple_spinner_dropdown_item, area_item)
        mSpinner.adapter = adapter

        findViewById<Button>(R.id.area_button).apply {//Button
            setOnClickListener {
                converter()
            }
        }
    }
    private fun converter(){
        val area_str = mEditinput.getText().toString()

        if(area_str.isEmpty()){
            toast("Empty Field")
            mEditinput.setError("Please fill the number")
            mTextrai.setText("")
            mTextnagn.setText("")
            mTextsquarewa.setText("")
            mTextsquarem.setText("")
            mTextsquarekm.setText("")

        }else {
            if(mSpinner.selectedItem == "Rai"){
                val input = area_str.toDouble()

                val rai = String.format("%.2f",input)
                val ngan = String.format("%.2f",input*4)
                val sqwa = String.format("%.2f",input*400)
                val sqm = String.format("%.2f",input*1600)
                val sqkm = String.format("%.2f",input*0.0016)

                mTextrai.setText(""+rai)
                mTextnagn.setText(""+ngan)
                mTextsquarewa.setText(""+sqwa)
                mTextsquarem.setText(""+sqm)
                mTextsquarekm.setText(""+sqkm)
            }
            if(mSpinner.selectedItem == "Ngan"){
                val input = area_str.toDouble()

                val rai = String.format("%.2f",input/4)
                val ngan = String.format("%.2f",input)
                val sqwa = String.format("%.2f",input*100)
                val sqm = String.format("%.2f",input*400)
                val sqkm = String.format("%.2f",input*0.0004)

                mTextrai.setText(""+rai)
                mTextnagn.setText(""+ngan)
                mTextsquarewa.setText(""+sqwa)
                mTextsquarem.setText(""+sqm)
                mTextsquarekm.setText(""+sqkm)
            }
            if(mSpinner.selectedItem == "Square Wa"){
                val input = area_str.toDouble()

                val rai = String.format("%.2f",input*0.0025)
                val ngan = String.format("%.2f",input*0.01)
                val sqwa = String.format("%.2f",input)
                val sqm = String.format("%.2f",input*4)
                val sqkm = String.format("%.5f",input*0.000004)

                mTextrai.setText(""+rai)
                mTextnagn.setText(""+ngan)
                mTextsquarewa.setText(""+sqwa)
                mTextsquarem.setText(""+sqm)
                mTextsquarekm.setText(""+sqkm)
            }
            if(mSpinner.selectedItem == "Square Meters"){
                val input = area_str.toDouble()

                val rai = String.format("%.2f",input*0.000625)
                val ngan = String.format("%.2f",input*0.0025)
                val sqwa = String.format("%.2f",input*0.25)
                val sqm = String.format("%.2f",input)
                val sqkm = String.format("%.5f",input*0.000001)

                mTextrai.setText(""+rai)
                mTextnagn.setText(""+ngan)
                mTextsquarewa.setText(""+sqwa)
                mTextsquarem.setText(""+sqm)
                mTextsquarekm.setText(""+sqkm)
            }
            if(mSpinner.selectedItem == "Square Kilometers"){
                val input = area_str.toDouble()

                val rai = String.format("%.2f",input*625)
                val ngan = String.format("%.2f",input*2500)//หา
                val sqwa = String.format("%.2f",input*250000)//หา
                val sqm = String.format("%.2f",input*1000000)
                val sqkm = String.format("%.2f",input)

                mTextrai.setText(""+rai)
                mTextnagn.setText(""+ngan)
                mTextsquarewa.setText(""+sqwa)
                mTextsquarem.setText(""+sqm)
                mTextsquarekm.setText(""+sqkm)
            }
            if (area_str.toDouble() == 0.0) {
                toast("Please Enter number more than 0")
                mEditinput.setError("Enter the number more than 0")
                mTextrai.setText("")
                mTextnagn.setText("")
                mTextsquarewa.setText("")
                mTextsquarem.setText("")
                mTextsquarekm.setText("")
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