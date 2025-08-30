package com.example.swproject

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PromotionWriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promotion_write)

        val photoInput = findViewById<EditText>(R.id.photoInput)
        val videoInput = findViewById<EditText>(R.id.videoInput)
        val videoContentInput = findViewById<EditText>(R.id.videoContentInput)
        val generateVideoBtn = findViewById<Button>(R.id.generateVideoBtn)

        generateVideoBtn.setOnClickListener {
            val photoPath = photoInput.text.toString()
            val videoPath = videoInput.text.toString()
            val videoContent = videoContentInput.text.toString()

            // 👉 여기서 입력받은 photoPath, videoPath, videoContent를 이용해서 영상 생성하는 로직을 연결하면 돼
        }
    }
}