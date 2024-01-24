package com.o7services.neerajjoshiclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    lateinit var etName: TextView
    lateinit var etRollNo: TextView
    var name = ""
    var rollNo = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        etName = findViewById(R.id.tvNameGet)
        etRollNo = findViewById(R.id.tvRollNoGet)

        intent.let {
             name = it.getStringExtra("name").toString()
             rollNo = it.getIntExtra("rollNo",0).toString()

            println("Name: $name , RollNo: $rollNo")
            etName.text = name
            etRollNo.text = rollNo
        }
    }
}