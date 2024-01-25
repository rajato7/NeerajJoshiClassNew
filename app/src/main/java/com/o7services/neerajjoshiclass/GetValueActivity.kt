package com.o7services.neerajjoshiclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.o7services.neerajjoshiclass.databinding.ActivityGetValueBinding

class GetValueActivity : AppCompatActivity() {
    lateinit var binding: ActivityGetValueBinding // declare binding
//    lateinit var etName : EditText // declare the EditText
//    lateinit var etRollNo: EditText
//    lateinit var btnSave: Button
//    lateinit var tvName: TextView
//    lateinit var tvRollNo: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetValueBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        etName = findViewById(R.id.etName) // intialize
//        etRollNo = findViewById(R.id.etRollNo)
//        btnSave= findViewById(R.id.btnSave)
//        tvName= findViewById(R.id.tvName)
//        tvRollNo= findViewById(R.id.tvRollNo)

        binding.btnSave.setOnClickListener{
            if(binding.etName.text.toString().isEmpty()){
                binding.etName.error = "Enter your name"
            }else if(binding.etRollNo.text.toString().isEmpty()){
                binding.etRollNo.error = "Enter Your Roll No."
            }else{
                println("My Name: ${binding.etName.text.toString()},My Roll No: ${binding.etRollNo.text.toString()} ")
                var intent = Intent(this,SecondActivity::class.java)
                intent.putExtra("name",binding.etName.text.toString())
                intent.putExtra("rollNo",binding.etRollNo.text.toString())
                startActivity(intent)
                binding.tvName.text = binding.etName.text.toString()
                binding.tvRollNo.text = binding.etRollNo.text.toString()
            }
        }

    }
}