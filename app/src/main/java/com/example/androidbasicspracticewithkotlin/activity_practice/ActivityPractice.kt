package com.example.androidbasicspracticewithkotlin.activity_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import com.example.androidbasicspracticewithkotlin.R

class ActivityPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("inside", "ActivityPractice oncreate")
        val str = savedInstanceState?.getString("data")
        Log.e("inside","->"+str)
        setContentView(R.layout.activity_practice)
        val textViewClick = findViewById(R.id.click) as TextView
        textViewClick.setOnClickListener {
            callActivityDemo()
        }
    }

    fun callActivityDemo(){
        val intent = Intent(this, ActivityPractice2::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.e("inside","ActivityPractice onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("inside","ActivityPractice onResume")
    }


    override fun onPause() {
        super.onPause()
        Log.e("inside","ActivityPractice onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.e("inside","ActivityPractice onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("inside","ActivityPractice onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("inside","ActivityPractice onRestart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("data","aksh")
        super.onSaveInstanceState(outState);

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        val str = savedInstanceState.getString("data")
        Log.e("inside","->"+str)
        super.onRestoreInstanceState(savedInstanceState)
    }
}