package com.example.myapplication

import android.content.IntentFilter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.myapplication.MyFragment
import com.example.myapplication.R


class MainActivity : AppCompatActivity() {

    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {

            val serviceResult = intent.getIntExtra(ADDITIONAL_RESULT, 0)

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.trash, MyFragment.newInstance(serviceResult))
                .commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var Btn = findViewById<Button>(R.id.button2)

        Btn.setOnClickListener {
            val serviceIntent = Intent(this, MyService::class.java)
            startService(serviceIntent)
        }
    }

    override fun onStart() {
        registerReceiver(broadcastReceiver, IntentFilter(ACTION))
        super.onStart()
    }

    override fun onStop() {
        unregisterReceiver(broadcastReceiver)
        super.onStop()
    }
}