package com.example.solutionchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
btn = findViewById(R.id.btn_to_profile)
        btn.setOnClickListener {
            intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}