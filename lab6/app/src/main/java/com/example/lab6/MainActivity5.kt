package com.example.lab6

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab6.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submit.setOnClickListener {
            val email = binding.emailText.text.toString()
            val password = binding.passwordText.text.toString()
            binding.textResult.visibility = View.VISIBLE

            if (email == "jj07073@gmail.com" && password == "1234") {
                binding.textResult.text = "비밀번호가 일치합니다"
            } else {
                binding.textResult.text = "비밀번호가 틀립니다"
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}