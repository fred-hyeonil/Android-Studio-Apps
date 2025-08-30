package com.example.swproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StoreConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_confirm)

        // 👉 전달받은 값 꺼내기
        val storeName = intent.getStringExtra("storeName")
        val storeCategory = intent.getStringExtra("storeCategory")

        // 👉 TextView에 표시하기
        val storeInfoText = findViewById<TextView>(R.id.storeInfoText)
        storeInfoText.text = "매장명: $storeName\n업종: $storeCategory"

        // 다음 화면 연결
        val nextBtn = findViewById<Button>(R.id.nextBtn)
        nextBtn.setOnClickListener {
            val intent = Intent(this, PromotionGenerateActivity::class.java)
            startActivity(intent)
        }
    }
}