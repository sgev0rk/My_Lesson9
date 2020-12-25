package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val intent: Intent = Intent().setAction(ACTION)
        intent.putExtra(ADDITIONAL_RESULT, sumbeetween2digits())
        sendBroadcast(intent)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    /* function that return the sum of all numbers in the range beetween a and b */
    private fun sumbeetween2digits(): Int {
        val a = (0..100).random()
        val b = (100..200).random()
        val sum = (a + b) * (b - a + 1) / 2
        return sum
    }
}