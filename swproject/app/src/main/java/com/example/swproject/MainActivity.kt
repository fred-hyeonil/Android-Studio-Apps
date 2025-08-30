package com.example.swproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val loginBtn = findViewById<Button>(R.id.loginBtn)
        loginBtn.setOnClickListener {
            val intent = Intent(this, StoreRegisterActivity::class.java)
            startActivity(intent)
        }

        val writePromotionBtn = findViewById<Button>(R.id.writePromotionBtn)
        writePromotionBtn.setOnClickListener {
            val intent = Intent(this, PromotionWriteActivity::class.java)
            startActivity(intent)
        }
    }
}