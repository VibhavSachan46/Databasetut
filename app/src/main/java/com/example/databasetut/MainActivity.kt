package com.example.databasetut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signupButton = findViewById<Button>(R.id.btnSignup)
        val etname = findViewById<EditText>(R.id.etName)
        val etMail = findViewById<EditText>(R.id.etmail)
        val userId = findViewById<EditText>(R.id.etuniqueId)
        val etpassworrd = findViewById<EditText>(R.id.etpassword)

        signupButton.setOnClickListener {
            val name = etname.text
            val mail = etMail.text
            val userid =userId.text
            val  password = etpassworrd.text

            database = FirebaseDatabase.getInstance().getReference("users")


        }

    }
}