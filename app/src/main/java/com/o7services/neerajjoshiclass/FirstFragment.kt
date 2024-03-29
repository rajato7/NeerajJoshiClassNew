package com.o7services.neerajjoshiclass

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.o7services.neerajjoshiclass.databinding.FragmentFirstBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    lateinit var fragmentActivity: FragmentActivity
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var name = ""
    var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentActivity = activity as FragmentActivity
        arguments?.let {
             name = it.getString("name").toString()
             password = it.getString("password").toString()


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater)
        binding.tvsetName.setText(name)
        binding.tvsetPassword.setText(password)
        binding.btnClick.setOnClickListener {
           var alertDialog = AlertDialog.Builder(fragmentActivity)
            alertDialog.setTitle("Alert Dialog")
            alertDialog.setMessage("Are you sure to logout?")
            alertDialog.setCancelable(false)
            alertDialog.setPositiveButton("Yes"){_,_->
                println("Hello AlertDialog yes")
            }
            alertDialog.setNegativeButton("No"){_,_->
                println("Hello AlertDialog No")
            }
            alertDialog.show()
        }
        binding.btnCustomDialog.setOnClickListener {
            var dialog = Dialog(fragmentActivity)
            dialog.setContentView(R.layout.custom_dialog)
            dialog.window?.setLayout(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT)

            var etName = dialog.findViewById<EditText>(R.id.etName)
            var btnSave = dialog.findViewById<Button>(R.id.btnSave)
            etName.setText(binding.tvsetName.text.toString())
            btnSave.setOnClickListener {
                if(etName.text.toString().isEmpty()){
                    etName.error = "Enter your name"
                }else{
                    binding.tvsetName.setText(etName.text.toString())
                    Toast.makeText(fragmentActivity,"Save",Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }


            dialog.show()
        }


        return binding.root

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Toast.makeText(requireActivity(), "onAttach", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}