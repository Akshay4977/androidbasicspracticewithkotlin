package com.example.androidbasicspracticewithkotlin.intent_demo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidbasicspracticewithkotlin.R
import com.example.androidbasicspracticewithkotlin.activity_practice.ActivityPractice


class IntentDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textView = findViewById<TextView>(R.id.text)
        val imageView = findViewById<ImageView>(R.id.image_view)

        textView.setOnClickListener {
            callActivityDemo()
            startYouTube()
            sendEmailImplicitIntentDemo()
        }
    }


    private fun callActivityDemo() {
        val intent = Intent(this, ActivityPractice::class.java) // Explicit intent
        startActivity(intent)
    }

    private fun startYouTube() {
        Intent(Intent.ACTION_MAIN).also { //explicit  intent
            it.`package` = "com.google.android.youtube"
            if (it.resolveActivity(packageManager) != null) {
                startActivity(it)
            }
        }
    }

    private fun sendEmailImplicitIntentDemo() {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_EMAIL, arrayListOf("abc@yopmail.com"))
            putExtra(Intent.EXTRA_SUBJECT, "this is subject")
            putExtra(Intent.EXTRA_TEXT, "this is content")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}