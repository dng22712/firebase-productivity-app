package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityTaskHourUpdationBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class taskHourUpdation : AppCompatActivity() {
    private lateinit var binding: ActivityTaskHourUpdationBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskHourUpdationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button8.setOnClickListener {
            val intent = Intent(this, userProgress::class.java)
            startActivity(intent)
        }
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child("Studies").get().addOnSuccessListener {

            binding.button5.setOnClickListener {
                val taskCompleted = binding.textView12.text.toString()
                updateData(taskCompleted)
            }
            val subject = it.child("name").value


            binding.textView9.text = subject.toString()
            var taskCompleted = it.child("taskCompleted").value
            var taskNum = (taskCompleted as String).toInt()

            binding.textView12.text = taskCompleted.toString()
            binding.button6.setOnClickListener {


                taskNum += 1

                binding.textView12.text = taskNum.toString()
            }
        }
        database.child("Fitness").get().addOnSuccessListener {
            binding.button9.setOnClickListener {
                val taskCompleted = binding.textView17.text.toString()
                updateData1(taskCompleted)
            }
            val workout = it.child("workout").value


            binding.textView16.text = workout.toString()
            var taskCompleted = it.child("caloriesBurnt").value
            var taskNum = (taskCompleted as String).toInt()

            binding.textView17.text = taskCompleted.toString()
            binding.button7.setOnClickListener {


                taskNum += 1

                binding.textView17.text = taskNum.toString()
            }
        }
    }


    private fun updateData(taskCompleted: String) {


        var database = FirebaseDatabase.getInstance().getReference("Users")
        val user = mapOf<String, String>(

            "taskCompleted" to taskCompleted
        )
        database.child("Studies").updateChildren(user).addOnSuccessListener {

            Toast.makeText(this, "Successfuly Updated", Toast.LENGTH_SHORT).show()

        }.addOnFailureListener {

            Toast.makeText(this, "Failed to Update", Toast.LENGTH_SHORT).show()

        }
    }


    private fun updateData1(caloriesBurnt: String) {


        var database = FirebaseDatabase.getInstance().getReference("Users")
        val user = mapOf<String, String>(

            "caloriesBurnt" to caloriesBurnt
        )
        database.child("Fitness").updateChildren(user).addOnSuccessListener {

            Toast.makeText(this, "Successfuly Updated", Toast.LENGTH_SHORT).show()

        }.addOnFailureListener {

            Toast.makeText(this, "Failed to Update", Toast.LENGTH_SHORT).show()

        }
    }
}

