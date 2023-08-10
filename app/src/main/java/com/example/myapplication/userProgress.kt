//    private var progressBar: ProgressBar? = null
//    private var i = 0
//    private var txtView: TextView? = null
//    private val handler = android.os.Handler()
//    private lateinit var binding: ActivityUserProgressBinding
//    private lateinit var database: DatabaseReference
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        binding = ActivityUserProgressBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_user_progress)
//        database = FirebaseDatabase.getInstance().reference.child("Users")
//
//        val db = database.child("Studies").get()
//        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
//        database = FirebaseDatabase.getInstance().getReference("Users")
//        database.child("Studies").updateChildren(subject).addOnSuccessListener {
//
//            progressBar.max = database.child("topic")
//
//        }
//
//
//        database = FirebaseDatabase.getInstance().getReference("Users")

//
//        database.child("Studies").get().addOnSuccessListener {
//
//            if (it.exists()) {
//
//                val subjectName = it.child("name").value
//                val topics = it.child("topics").value
//                val date = it.child("date").value
//                progressBar.max = 100
//                val currentProgress = 20
//
//                ObjectAnimator.ofInt(progressBar, "progress", currentProgress).start()
//
//            } else {
//
//                Toast.makeText(this, "User Doesn't Exist", Toast.LENGTH_SHORT).show()
//
//            }
//
//        }.addOnFailureListener {
//
//            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
//
//        }
//
//}

// User progress counter
package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import com.example.myapplication.databinding.ActivityUserProgressBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class userProgress : AppCompatActivity() {

    private lateinit var binding: ActivityUserProgressBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button15.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.button14.setOnClickListener {
            val intent = Intent(this, taskHourUpdation::class.java)
            startActivity(intent)
        }
        val Studies = binding.textView11.toString()
        readData(Studies)
        val Fitness = binding.textView21.toString()
        readData2(Fitness)



    }

    //Reading data from firebase
    private fun readData(Studies: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child("Studies").get().addOnSuccessListener {
            if (it.exists()) {
                val name = it.child("name").value
                val topics = it.child("topics").value
                val deadline = it.child("date").value
                val taskCompleted = it.child("taskCompleted").value
                var progressBar = binding.progressBar
                var progressBar1 = (topics as String).toInt()
                var progressBar2 = (taskCompleted as String).toInt()
                progressBar.max = progressBar1
                progressBar.progress = progressBar2

                Toast.makeText(this, "Successfuly Read", Toast.LENGTH_SHORT).show()

                binding.textView13.text = name.toString()
                binding.textView18.text = taskCompleted.toString()


//                binding.tvAge.text = age.toString()

            } else {

                Toast.makeText(this, "User Doesn't Exist", Toast.LENGTH_SHORT).show()

            }

        }.addOnFailureListener {

            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()


        }
    }


        private fun readData2(Fitness: String) {

            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child("Fitness").get().addOnSuccessListener{

                if (it.exists()) {

                    val name = it.child("workout").value
                    val topics = it.child("calories").value

                    val deadline = it.child("date").value
                    val taskCompleted = it.child("caloriesBurnt").value
                    var progressBar = binding.progressBar2
                    var progressBar3 = (topics as String).toInt()
                    var progressBar4 = (taskCompleted as String).toInt()
                    progressBar.max = progressBar3
                    progressBar.progress = progressBar4


                    Toast.makeText(this, "Successfuly Read", Toast.LENGTH_SHORT).show()

                    binding.textView22.text = name.toString()
                    binding.textView24.text = taskCompleted.toString()


//                binding.tvAge.text = age.toString()

                } else {

                    Toast.makeText(this, "User Doesn't Exist", Toast.LENGTH_SHORT).show()

                }

            }.addOnFailureListener {

                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()


            }
        }

//    private fun readData3(Others: String) {
//
//        database = FirebaseDatabase.getInstance().getReference("Users")
//        database.child("Others").get().addOnSuccessListener{
//
//            if (it.exists()) {
//
//                val name = it.child("task").value
//                val topics = it.child("count").value
//
//                val deadline = it.child("date").value
//                val taskCompleted = it.child("taskCompleted").value
//
////                binding.progressBar.max = topics as Int
//
//
//                Toast.makeText(this, "Successfuly Read", Toast.LENGTH_SHORT).show()
//
//                binding.textView26.text = name.toString()
//                binding.textView28.text = taskCompleted.toString()
//
//
////                binding.tvAge.text = age.toString()
//
//            } else {
//
//                Toast.makeText(this, "User Doesn't Exist", Toast.LENGTH_SHORT).show()
//
//            }
//
//        }.addOnFailureListener {
//
//            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
//
//
//        }
//    }

//        database.child("Studies").get().addOnSuccessListener {
//
//    }



}


