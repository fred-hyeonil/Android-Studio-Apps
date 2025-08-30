package com.example.swproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class StoreRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_register)

        val nextBtn = findViewById<Button>(R.id.nextBtn)

        // 👉 입력된 값 가져오기
        val storeNameInput = findViewById<EditText>(R.id.storeNameInput)
        val storeCategoryInput = findViewById<EditText>(R.id.storeCategoryInput)

        nextBtn.setOnClickListener {
            val storeName = storeNameInput.text.toString()
            val storeCategory = storeCategoryInput.text.toString()

            val intent = Intent(this, StoreConfirmActivity::class.java)
            intent.putExtra("storeName", storeName)
            intent.putExtra("storeCategory", storeCategory)
            startActivity(intent)
        }
    }
}