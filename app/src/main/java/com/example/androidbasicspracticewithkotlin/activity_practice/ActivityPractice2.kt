package com.example.androidbasicspracticewithkotlin.activity_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidbasicspracticewithkotlin.R

class ActivityPractice2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("inside", "oncreate")
        setContentView(R.layout.activity_practice)
    }

    override fun onStart() {
        super.onStart()
        Log.e("inside","ActivityPractice2 onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("inside"," ActivityPractice2 onResume")
    }


    override fun onPause() {
        super.onPause()
        Log.e("inside","ActivityPractice2 onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.e("inside","ActivityPractice2 onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("inside","ActivityPractice2 onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("inside","ActivityPractice2 onRestart")
    }
}