package com.example.myapplication

import android.app.DatePickerDialog
import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.databinding.ActivityGoalCreationBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.auth.User
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app
import java.text.SimpleDateFormat
import java.util.*

class OtherGoals : AppCompatActivity() {
    private lateinit var binding: ActivityGoalCreationBinding
    private lateinit var database: DatabaseReference

    //
//private var db = Firebase.app
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityGoalCreationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView3.setOnClickListener{
            val intent =Intent(this,Login::class.java)
            startActivity(intent)
        }
        binding.tanggal.setOnClickListener {
            setDate()
        }
        binding.button2.setOnClickListener {

            val task = binding.name.text.toString()
            val count = binding.topics.text.toString()
            val dateText = binding.dateText.text.toString()
            val taskCompleted = binding.textView10.text.toString()

            if (task.isNotEmpty() && count.isNotEmpty() && dateText.isNotEmpty() ) {

                updateData(task, count , dateText ,taskCompleted)

                val intent = Intent(this, userProgress::class.java)
                startActivity(intent)
//                        if (it.isSuccessful) {
//                            val intent = Intent(this, Login::class.java)
//                            startActivity(intent)
//                        } else {
//                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
//                        }
//
//                    }


            } else {
                Toast.makeText(this, "Empty fields are not allowed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateData(task: String, count: String, dateText: String,taskCompleted: String ) {


        database = FirebaseDatabase.getInstance().getReference("Users")


        val user = mapOf<String, Any>(
            "task" to task,
            "count" to count,
            "date" to dateText,
            "taskCompleted" to taskCompleted
        )


        database.child("Others").updateChildren(user).addOnSuccessListener {

            binding.name.text.clear()
            binding.topics.text.clear()

            Toast.makeText(this, "Successfuly Updated", Toast.LENGTH_SHORT).show()

        }.addOnFailureListener {

            Toast.makeText(this, "Failed to Update", Toast.LENGTH_SHORT).show()

        }
    }

    private fun setDate() {
        val datePicker = Calendar.getInstance()
        val date =
            DatePickerDialog.OnDateSetListener { view: DatePicker?, year: Int, month: Int, dayOfMonth: Int ->
                datePicker[Calendar.YEAR] = year
                datePicker[Calendar.MONTH] = month
                datePicker[Calendar.DAY_OF_MONTH] = dayOfMonth
                val dateFormat = "dd-MMMM-yyyy"
                val simpleDateFormat = SimpleDateFormat(
                    dateFormat,
                    Locale.getDefault()
                )
                binding.dateText.text = simpleDateFormat.format(
                    datePicker.time
                )
            }
        DatePickerDialog(
            this@OtherGoals, date,
            datePicker[Calendar.YEAR],
            datePicker[Calendar.MONTH],
            datePicker[Calendar.DAY_OF_MONTH]
        ).show()
    }
}

