package com.example.androidbasicspracticewithkotlin

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidbasicspracticewithkotlin.activity_practice.ActivityPractice
import com.example.androidbasicspracticewithkotlin.broadcast_reciever.AlarmReceiver
import com.example.androidbasicspracticewithkotlin.broadcast_reciever.ConnectionReceiver
import com.example.androidbasicspracticewithkotlin.broadcast_reciever.TestReceiver
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {

    val fil = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
    val fil1 = IntentFilter("Test_action")
    val receiver = ConnectionReceiver()
    val testReceiver = TestReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textView = findViewById<TextView>(R.id.text)
        val imageView = findViewById<ImageView>(R.id.image_view)
        if (Intent.ACTION_SEND == intent.action && intent.type?.startsWith("image/") == true) {
            handleReceivedImage(intent, imageView)
        }
        registerIntent()

        textView.setOnClickListener {
            //callActivityDemo()
            //startYouTube()
            //sendEmailImplicitIntentDemo()
            //unRegisterIntent()
            temp()
        }
    }


    private fun handleReceivedImage(intent: Intent, imageView: ImageView) {
        val imageUri = intent.getParcelableExtra<Uri>(Intent.EXTRA_STREAM)
        if (imageUri != null) {
            Log.e("inside", "->" + imageUri)
            Picasso.get().load(imageUri).into(imageView)
        }
    }

    /*override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val extra = intent?.extras
        val uri = Uri.parse(extra?.getString("imageUri"))
        //Picasso.get().load(uri).into(image_view)


        val uri1 = intent?.getParcelableExtra<Uri>(Intent.EXTRA_STREAM)
        Picasso.get().load(uri1).into(image_view)
    }*/

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

    private fun registerIntent() {
        registerReceiver(receiver, fil)
        registerReceiver(testReceiver, fil1)
    }

    private fun unRegisterIntent() {
        unregisterReceiver(receiver)

    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }

    fun temp(){
        val intent = Intent(applicationContext, AlarmReceiver::class.java)
        intent.putExtra("time","4")
        sendBroadcast(intent)

        val pendingIntent = PendingIntent.getBroadcast(this, 1, intent,  PendingIntent.FLAG_UPDATE_CURRENT)
        val am: AlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        am.setRepeating(AlarmManager.RTC, 4 * 1000, AlarmManager.INTERVAL_DAY, pendingIntent);
    }


}