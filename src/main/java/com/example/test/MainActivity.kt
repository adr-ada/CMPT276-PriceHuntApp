package com.example.test

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
        val btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener{
            val firstName = findViewById<EditText>(R.id.etFirstName)
            val lastName = findViewById<EditText>(R.id.etLastName)
            val statusUpdate = findViewById<TextView>(R.id.tvStatusUpdate)
            //tvStatusUpdate.text.to
        }

        //}
    }
}