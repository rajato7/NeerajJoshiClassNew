package com.o7services.neerajjoshiclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnConstraint: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnConstraint = findViewById(R.id.btnConstraint)

        btnConstraint.setOnClickListener{
            var intent = Intent(this, ConstraintActivity::class.java)
            startActivity(intent)
        }
    }
}