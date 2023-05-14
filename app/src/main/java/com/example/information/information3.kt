package com.example.information

import android.os.Bundle
import android.text.method.DigitsKeyListener
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [information3.newInstance] factory method to
 * create an instance of this fragment.
 */
class information3 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var nextFragment2: Button
    private lateinit var seniorBoy : ImageView
    private lateinit var info3text : TextView
    private lateinit var info3text2 : TextView
    private lateinit var info3text3 : TextView
    private lateinit var inputHeight: EditText
    private lateinit var inputWeight: EditText

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
        val view = inflater.inflate(R.layout.fragment_information3, container, false)
        nextFragment2 = view.findViewById(R.id.information3_button)
        inputHeight = view.findViewById(R.id.information3_inputText)
        inputWeight = view.findViewById(R.id.information3_inputText2)
        seniorBoy = view.findViewById(R.id.information3_image)
        info3text = view.findViewById(R.id.information3_text)
        info3text2 = view.findViewById(R.id.information3_text2)
        info3text3 = view.findViewById(R.id.information3_text3)
        val digitsKeyListener = DigitsKeyListener.getInstance("0123456789")
        inputHeight.keyListener = digitsKeyListener
        inputWeight.keyListener = digitsKeyListener
        nextFragment2.setOnClickListener {
            replaceFragment(getStart())
            nextFragment2.visibility = View.INVISIBLE
            inputWeight.visibility = View.INVISIBLE
            inputHeight.visibility = View.INVISIBLE
            seniorBoy.visibility = View.INVISIBLE
            info3text3.visibility = View.INVISIBLE
            info3text.visibility = View.INVISIBLE
            info3text2.visibility = View.INVISIBLE
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
         * @return A new instance of fragment information3.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            information3().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private fun replaceFragment(fragment : Fragment) {
        val nextFragment = getStart()
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.remove(fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(R.id.fragment_container3,fragment)
        fragmentTransaction.commit()
    }
}