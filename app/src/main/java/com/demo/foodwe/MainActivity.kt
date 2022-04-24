package com.demo.foodwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent1 = Intent(this,homeactivity::class.java)
       GlobalScope.launch(newSingleThreadContext("My thread")) {
           delay(3000)
            startActivity(intent1)
                finish()
        }

    }
}