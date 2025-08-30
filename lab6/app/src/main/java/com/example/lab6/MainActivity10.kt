package com.example.lab6

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab6.databinding.ActivityMain10Binding

class MainActivity10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding=ActivityMain10Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1.setOnClickListener{
            binding.tv1.visibility= View.VISIBLE
            binding.tv2.visibility= View.INVISIBLE
            binding.tv3.visibility= View.INVISIBLE
        }
        binding.button2.setOnClickListener{
            binding.tv1.visibility= View.INVISIBLE
            binding.tv2.visibility= View.VISIBLE
            binding.tv3.visibility= View.INVISIBLE
        }
        binding.button3.setOnClickListener{
            binding.tv1.visibility= View.INVISIBLE
            binding.tv2.visibility= View.INVISIBLE
            binding.tv3.visibility= View.VISIBLE
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}