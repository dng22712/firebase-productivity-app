package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityRegisterBinding
//import com.example.myapplication.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()
            val confirmPass = binding.confirmPassEt.text.toString()
            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, Login::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }

                    }
                } else {
                    Toast.makeText(this, "Password Not Matching", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "Empty fields are not allowed", Toast.LENGTH_SHORT).show()
            }
        }
    }

}

//package com.example.myapplication
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import com.example.myapplication.databinding.ActivityRegisterBinding
//import com.google.firebase.database.DatabaseReference
//import com.google.firebase.database.FirebaseDatabase
//
//class Register : AppCompatActivity() {
//
//    private lateinit var binding: ActivityRegisterBinding
//    private lateinit var database : DatabaseReference
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityRegisterBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.registerBtn.setOnClickListener {
//
//            val userName = binding.userName.text.toString()
//            val firstName = binding.firstName.text.toString()
//            val lastName = binding.lastName.text.toString()
//            val passWord = binding.passWord.text.toString()
//
//            updateData(userName,firstName,lastName,passWord)
//
//        }
//
//    }
//
//    private fun updateData(userName: String, firstName: String, lastName: String, passWord: String) {
//
//        database = FirebaseDatabase.getInstance().getReference("Users")
//        val user = mapOf<String,String>(
//            "firstName" to firstName,
//            "lastName" to lastName,
//            "userName" to userName,
//            "password" to passWord
//        )
//
//        database.child(userName).updateChildren(user).addOnSuccessListener {
//
//            binding.userName.text.clear()
//            binding.firstName.text.clear()
//            binding.lastName.text.clear()
//            binding.passWord.text.clear()
//
//            Toast.makeText(this,"Successfuly Updated",Toast.LENGTH_SHORT).show()
//
//        }.addOnFailureListener{
//
//            Toast.makeText(this,"Failed to Update",Toast.LENGTH_SHORT).show()
//
//        }}

// Register xml

//<?xml version="1.0" encoding="utf-8"?>
//<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
//xmlns:app="http://schemas.android.com/apk/res-auto"
//xmlns:tools="http://schemas.android.com/tools"
//android:layout_width="match_parent"
//android:layout_height="match_parent"
//android:background="@color/blue_Light"
//tools:context=".MainActivity">
//
//<androidx.constraintlayout.widget.ConstraintLayout
//android:layout_width="match_parent"
//android:layout_height="match_parent">
//
//<ImageView
//android:id="@+id/imageView"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:src="@drawable/bb"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toTopOf="parent" />
//
//
//<TextView
//android:id="@+id/textView2"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:layout_marginTop="180dp"
//android:text="REGISTRATION"
//android:textColor="@color/black"
//android:textSize="30sp"
//android:textStyle="bold"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintHorizontal_bias="0.497"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toTopOf="parent" />
//
//<EditText
//android:id="@+id/firstName"
//android:layout_width="360dp"
//android:layout_height="50dp"
//android:layout_marginTop="36dp"
//android:background="@drawable/common_google_signin_btn_icon_dark"
//android:hint="First Name"
//android:paddingLeft="20dp"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toBottomOf="@+id/textView2" />
//
//<EditText
//android:id="@+id/lastName"
//android:layout_width="360dp"
//android:layout_height="50dp"
//android:layout_marginTop="32dp"
//android:background="@drawable/common_google_signin_btn_icon_dark"
//android:hint="Last Name"
//android:paddingLeft="20dp"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toBottomOf="@+id/firstName" />
//
//<EditText
//android:id="@+id/passWord"
//android:layout_width="360dp"
//android:layout_height="50dp"
//android:layout_marginTop="32dp"
//android:background="@drawable/common_google_signin_btn_icon_dark_focused"
//android:hint="password"
//android:paddingLeft="20dp"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toBottomOf="@+id/lastName" />
//
//<EditText
//android:id="@+id/userName"
//android:layout_width="360dp"
//android:layout_height="50dp"
//android:layout_marginTop="32dp"
//android:background="@drawable/aa"
//android:hint="Username"
//android:paddingLeft="20dp"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toBottomOf="@+id/passWord" />
//
//<Button
//android:id="@+id/registerBtn"
//android:layout_width="360dp"
//android:layout_height="60dp"
//android:layout_gravity="center_horizontal"
//android:layout_marginTop="612dp"
//android:backgroundTint="@color/teal_200"
//android:text="Login"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toTopOf="parent" />
//
//</androidx.constraintlayout.widget.ConstraintLayout>
//</ScrollView>