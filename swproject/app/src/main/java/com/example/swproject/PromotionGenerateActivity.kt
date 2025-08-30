package com.example.swproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PromotionGenerateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promotion_generate)

        findViewById<Button>(R.id.generatePostBtn).setOnClickListener {
            Toast.makeText(this, "SNS 글 생성!", Toast.LENGTH_SHORT).show()
            moveToDisplay("post")
        }

        findViewById<Button>(R.id.generatePosterBtn).setOnClickListener {
            Toast.makeText(this, "포스터 생성!", Toast.LENGTH_SHORT).show()
            moveToDisplay("poster")
        }

        findViewById<Button>(R.id.generateVideoBtn).setOnClickListener {
            Toast.makeText(this, "영상 생성!", Toast.LENGTH_SHORT).show()
            moveToDisplay("video")
        }
    }

    private fun moveToDisplay(type: String) {
        val intent = Intent(this, ContentDisplayActivity::class.java)
        intent.putExtra("type", type)
        startActivity(intent)
    }
}