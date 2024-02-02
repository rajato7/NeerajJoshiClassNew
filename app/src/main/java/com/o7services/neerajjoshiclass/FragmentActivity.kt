package com.o7services.neerajjoshiclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.o7services.neerajjoshiclass.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {
    lateinit var binding: ActivityFragmentBinding
    lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.ContainerView)

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    navController.navigate(R.id.firstFragment)
                }
                R.id.second -> {
                    navController.navigate(R.id.secondFragment)
                }
                else -> {}
            }
            return@setOnItemSelectedListener true
        }
        navController.addOnDestinationChangedListener{_,destination,_->
            when(destination.id){
                R.id.firstFragment->{
                    binding.bottomNav.menu.findItem(R.id.home).isChecked = true
                }
                R.id.secondFragment->{
                    binding.bottomNav.menu.findItem(R.id.second).isChecked = true
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    }
}