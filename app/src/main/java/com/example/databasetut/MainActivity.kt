package com.example.databasetut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signupButton = findViewById<Button>(R.id.btnSignup)
        val etname = findViewById<TextInputEditText>(R.id.etName)
        val etMail = findViewById<TextInputEditText>(R.id.etmail)
        val userId = findViewById<TextInputEditText>(R.id.etuniqueId)
        val etpassworrd = findViewById<TextInputEditText>(R.id.etpassword)

        signupButton.setOnClickListener {
            val name = etname.text.toString()
            val mail = etMail.text.toString()
            val uniqueId =userId.text.toString()
            val  password = etpassworrd.text.toString()

            val user = user(name ,mail, password, uniqueId)
            database = FirebaseDatabase.getInstance().getReference("users")
             //from user.kt

            database.child(uniqueId).setValue(user).addOnSuccessListener {
                etname.text?.clear()
                etMail.text?.clear()
                userId.text?.clear()
                etpassworrd.text?.clear()
                Toast.makeText(this,"Uset registered",Toast.LENGTH_SHORT).show()
            }

        }
    }
}