package com.o7services.neerajjoshiclass

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.o7services.neerajjoshiclass.databinding.FragmentSecondBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    lateinit var binding : FragmentSecondBinding
    lateinit var fragmentActivity: FragmentActivity
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var arrayAdapter: ArrayAdapter<String> // declare the arrayAdapter
    var gender = arrayOf("Male","Female","Others") // create array for multiple values


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentActivity = activity as FragmentActivity
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater)
        binding.btnSecond.setOnClickListener {
            fragmentActivity.navController.popBackStack()
        }
        binding.btnSave.setOnClickListener {
            if(binding.etName.text.toString().isEmpty()){
                binding.etName.error = resources.getString(R.string.enter_name)
            }else if(binding.etPassword.text.toString().isEmpty()){
                binding.etPassword.error = resources.getString(R.string.enter_password)
            }else{
                var bundle = Bundle()
                bundle.putString("name",binding.etName.text.toString())
                bundle.putString("password",binding.etPassword.text.toString())
                fragmentActivity.navController.navigate(R.id.firstFragment,bundle)
            }
        }

        // intialaize the arrayAdapter
        arrayAdapter = ArrayAdapter(fragmentActivity,android.R.layout.simple_list_item_1,gender)
        binding.spinner.adapter = arrayAdapter // set adapter to the spinner to show the items


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}