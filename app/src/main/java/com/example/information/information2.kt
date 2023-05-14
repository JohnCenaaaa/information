package com.example.information

import android.os.Bundle
import android.text.method.DigitsKeyListener
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.FragmentManager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [information2.newInstance] factory method to
 * create an instance of this fragment.
 */
class information2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var info2Text: TextView
    private lateinit var genderChange: ImageView
    private lateinit var info2Text2: TextView
    private lateinit var info2Text3: TextView
    private lateinit var info2Text4: TextView
    private lateinit var inputAge: EditText
    private lateinit var inputName: EditText
    private lateinit var spinner: Spinner
    private lateinit var nextFragment: Button

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
        val view = inflater.inflate(R.layout.fragment_information2, container, false)
        info2Text = view.findViewById(R.id.information2_text)
        info2Text2 = view.findViewById(R.id.information2_text2)
        info2Text3 = view.findViewById(R.id.information2_text3)
        info2Text4 = view.findViewById(R.id.information2_text4)
        spinner = view.findViewById(R.id.information2_spinner)
        genderChange= view.findViewById(R.id.information2_image)
        nextFragment = view.findViewById(R.id.information2_button)
        inputName = view.findViewById(R.id.information2_inputText)
        inputAge = view.findViewById(R.id.information2_inputText2)
        val digitsKeyListener = DigitsKeyListener.getInstance("0123456789")
        inputAge.keyListener = digitsKeyListener
        // Create an ArrayAdapter using a string array and a default spinner layout
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.spinner_items,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedGender = parent.getItemAtPosition(position).toString()

                // Update the image based on the selected gender
                if (selectedGender == "Male") {
                    genderChange.setImageResource(R.drawable.boy_child)
                } else if (selectedGender == "Female") {
                    genderChange.setImageResource(R.drawable.girl_child)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        nextFragment.setOnClickListener {
            val name = inputName.text.toString().trim()
            val age = inputAge.text.toString().trim()
            if (name.isEmpty()) {
                inputName.error = "Please enter your name"
            } else if (age.isEmpty()) {
                inputAge.error = "Please enter your age"
            } else {
                replaceFragment(information3())
                genderChange.visibility = View.INVISIBLE
                info2Text.visibility = View.INVISIBLE
                info2Text2.visibility = View.INVISIBLE
                info2Text3.visibility = View.INVISIBLE
                info2Text4.visibility = View.INVISIBLE
                spinner.visibility = View.INVISIBLE
                inputAge.visibility = View.INVISIBLE
                inputName.visibility = View.INVISIBLE
                nextFragment.visibility = View.INVISIBLE
            }
        }
        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment information2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            information2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private fun replaceFragment(fragment : Fragment) {
        val nextFragment = information3()
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.remove(fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(R.id.fragment_container2,fragment)
        fragmentTransaction.commit()
    }
}