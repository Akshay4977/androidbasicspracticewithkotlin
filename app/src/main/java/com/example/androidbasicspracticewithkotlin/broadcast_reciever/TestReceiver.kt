package com.example.androidbasicspracticewithkotlin.broadcast_reciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log


class TestReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action =="Test_action"){
            Log.e("inside","onReceive")
        }
    }

}