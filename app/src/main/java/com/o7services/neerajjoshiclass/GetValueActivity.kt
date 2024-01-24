package com.o7services.neerajjoshiclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class GetValueActivity : AppCompatActivity() {
    lateinit var etName : EditText // declare the EditText
    lateinit var etRollNo: EditText
    lateinit var btnSave: Button
    lateinit var tvName: TextView
    lateinit var tvRollNo: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_value)
        etName = findViewById(R.id.etName) // intialize
        etRollNo = findViewById(R.id.etRollNo)
        btnSave= findViewById(R.id.btnSave)
        tvName= findViewById(R.id.tvName)
        tvRollNo= findViewById(R.id.tvRollNo)

        btnSave.setOnClickListener{
            if(etName.text.toString().isEmpty()){
                etName.error = "Enter your name"
            }else if(etRollNo.text.toString().isEmpty()){
                etRollNo.error = "Enter Your Roll No."
            }else{
                println("My Name: ${etName.text.toString()},My Roll No: ${etRollNo.text.toString()} ")
                var intent = Intent(this,SecondActivity::class.java)
                intent.putExtra("name",etName.text.toString())
                intent.putExtra("rollNo",etRollNo.text.toString())
                startActivity(intent)
                tvName.text = etName.text.toString()
                tvRollNo.text = etRollNo.text.toString()
            }
        }

    }
}