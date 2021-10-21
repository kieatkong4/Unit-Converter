package com.example.miniproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openLength(view: View){
        val it = Intent(this@MainActivity, LengthActivity2::class.java)
        startActivity(it)
    }
    fun openArea(view: View){
        val it = Intent(this@MainActivity, AreaActivity::class.java)
        startActivity(it)
    }
    fun openWeight(view: View){
        val it = Intent(this@MainActivity, WeightActivity::class.java)
        startActivity(it)
    }
    fun openTemp(view: View){
        val it = Intent(this@MainActivity, TempActivity::class.java)
        startActivity(it)
    }


}