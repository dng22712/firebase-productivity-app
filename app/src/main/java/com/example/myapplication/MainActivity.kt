package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.textView2.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        binding.studyGoals.setOnClickListener {
            val intent = Intent(this, GoalCreation::class.java)
            startActivity(intent)}

            binding.button4.setOnClickListener {
                val intent = Intent(this, FitnessCreate::class.java)
                startActivity(intent)
            }
        binding.button3.setOnClickListener {
            val intent = Intent(this, OtherGoals::class.java)
            startActivity(intent)
        }

    }
}