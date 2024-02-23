package com.example.androidbasicspracticewithkotlin.broadcast_reciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        val action = intent!!.action
        Log.e("inside", "Broadcast received")
        if (action == "my.action.string") {
            val state = intent.extras!!.getString("time")
            Log.e("inside", "Broadcast received: $state")
        }
    }

}