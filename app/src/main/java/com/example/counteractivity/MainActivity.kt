package com.example.counteractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.content.pm.ActivityInfo

class MainActivity : AppCompatActivity() {

    var counter = 0

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("COUNTER_KEY",counter)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toastButton = findViewById<Button>(R.id.button_toast)
        val counterButton = findViewById<Button>(R.id.button_counter)
        var text = findViewById<TextView>(R.id.text_id)

        toastButton.setOnClickListener {
            val toast =
                Toast.makeText(this, "A toast message is displayed", Toast.LENGTH_SHORT).show()
        }

        counterButton.setOnClickListener {
            Log.d("TAG123456", "Counter button has been clicked!")
        }



        val persistantCurrentNumber = savedInstanceState?.getInt("COUNTER_KEY")
        if (persistantCurrentNumber != null){
            counter = persistantCurrentNumber
            text.setText(counter.toString())
        }
        counterButton.setOnClickListener {
            counter++
            text.setText(counter.toString())
        }

        Log.d("TAG123", "onCreate")
    }

        override fun onStart() {
            super.onStart()
            Log.d("TAG123", "onStart")
        }

        override fun onResume() {
            super.onResume()
            Log.d("TAG123", "onResume")
        }

        override fun onStop() {
            super.onStop()
            Log.d("TAG123", "onStop")
        }

        override fun onPause() {
            super.onPause()
            Log.d("TAG123", "onPause")
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.d("TAG123", "onDestroy")
        }



}