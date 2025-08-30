package com.example.lab6

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab6.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding= ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.visibleBtn.setOnClickListener({
            binding.targetView.visibility= View.VISIBLE
            binding.targetView.setText("aaaaaaaaa")
        })
        binding.invisibleBtn.setOnClickListener({
            binding.targetView.visibility= View.INVISIBLE
        })
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}