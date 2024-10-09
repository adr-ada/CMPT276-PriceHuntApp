package com.example.test

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //enableEdgeToEdge()

//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//
//            // this is a ttt
//        }

        val firstName = findViewById<EditText>(R.id.etFirstName)
        val lastName = findViewById<EditText>(R.id.etLastName)
        val streetAddress = findViewById<EditText>(R.id.etStreetAddress)
        val city = findViewById<EditText>(R.id.etCity)

        val province = findViewById<EditText>(R.id.etProvince)
        val postalCode = findViewById<EditText>(R.id.etPostalCode)
        val email = findViewById<EditText>(R.id.etEmailAddress)
        val phoneNumber = findViewById<EditText>(R.id.etPhoneNumber)

        val btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener{
            firstName.setText(" ")
            lastName.setText(" ")
            streetAddress.setText(" ")
            city.setText(" ")
            province.setText(" ")
            postalCode.setText(" ")
            email.setText(" ")
            phoneNumber.setText(" ")
            Toast.makeText(this, "Changes have been saved!", Toast.LENGTH_SHORT).show()
        }
    }
}