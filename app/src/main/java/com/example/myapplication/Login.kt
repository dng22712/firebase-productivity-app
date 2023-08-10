package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener {
            val intent = Intent(this,Register::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
    }

//
}

//package com.example.myapplication
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import com.example.myapplication.databinding.ActivityLoginBinding
//import com.google.firebase.database.DatabaseReference
//import com.google.firebase.database.FirebaseDatabase
//
//class Login : AppCompatActivity() {
//
//    private lateinit var binding : ActivityLoginBinding
//    private lateinit var database : DatabaseReference
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityLoginBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.readdataBtn.setOnClickListener {
//
//            val userName : String = binding.etusername.text.toString()
//            val passWord : String = binding.etPassword.text.toString()
//            if  (userName.isNotEmpty() && passWord.isNotEmpty()){
//                readData(userName, passWord)
//            }
//            else{
//                Toast.makeText(this,"PLease enter the Username",Toast.LENGTH_SHORT).show()
//            }
//
//        }
//
//    }
//
//    private fun readData(userName: String, passWord: String) {
//
//        database = FirebaseDatabase.getInstance().getReference("Users")
//        database = FirebaseDatabase.getInstance().getReference("password")
//        database.child(userName).get().addOnSuccessListener  {
//
//            if (it.exists()){
//
////                val firstname = it.child("firstName").value
////                val lastName = it.child("lastName").value
////                val password = it.child("password").value
//
//                Toast.makeText(this,"Successfuly Read",Toast.LENGTH_SHORT).show()
//                binding.etusername.text.clear()
//                binding.etPassword.text.clear()
//
////                binding.tv.text = firstname.toString()
////                binding.tvLastName.text = lastName.toString()
////                binding.tvAge.text = age.toString()
//
//            }
//
//            else {
//
//                Toast.makeText(this,"User Doesn't Exist",Toast.LENGTH_SHORT).show()
//
//            }
//
//        }.addOnFailureListener{
//
//            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
//
//        }
//    }
//
//
//}
