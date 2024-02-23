package com.example.androidbasicspracticewithkotlin.broadcast_reciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import android.provider.Settings

class ConnectionReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        if (isAirplaneModeOn(context.applicationContext)) {
            Toast.makeText(context, "AirPlane mode is on", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "AirPlane mode is off", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isAirplaneModeOn(context: Context): Boolean {
        return Settings.System.getInt(
            context.contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0
        ) !== 0
    }
}