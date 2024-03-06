package com.o7services.neerajjoshiclass

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import com.o7services.neerajjoshiclass.databinding.FragmentListViewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListViewFragment : Fragment() {
    lateinit var binding: FragmentListViewBinding
    var names = arrayListOf<String>("Test","Test 1","Test 2")
    lateinit var arrayAdapter: ArrayAdapter<String>

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        binding = FragmentListViewBinding.inflate(layoutInflater)
        arrayAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,names)
        binding.lvList.adapter = arrayAdapter

        binding.fabBtn.setOnClickListener {
            var dialog = Dialog(requireActivity())
            dialog.setContentView(R.layout.custom_dialog)
            var name = dialog.findViewById<EditText>(R.id.etName)
            var save = dialog.findViewById<Button>(R.id.btnSave)
            save.setOnClickListener {
                if(name.text.toString().isEmpty()){
                    name.error = resources.getString(R.string.enter_name)
                }else{
                    names.add(name.text.toString())
                    dialog.dismiss()
                    arrayAdapter.notifyDataSetChanged()
                }
            }
           dialog.show()
        }
        binding.lvList.setOnItemClickListener { parent, view, position, id ->
           var dialog = Dialog(requireActivity())
            dialog.setContentView(R.layout.custom_dialog)
            var name = dialog.findViewById<EditText>(R.id.etName)
            var save = dialog.findViewById<Button>(R.id.btnSave)
            save.setOnClickListener {
                if(name.text.toString().isEmpty()){
                    name.error = resources.getString(R.string.enter_name)
                }else{
                    names.set(position,name.text.toString())
                    dialog.dismiss()
                    arrayAdapter.notifyDataSetChanged()
                }
            }
            dialog.show()
        }
        binding.lvList.setOnItemLongClickListener { parent, view, position, id ->
            names.removeAt(position)
            arrayAdapter.notifyDataSetChanged()
            return@setOnItemLongClickListener true
        }


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListViewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListViewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}