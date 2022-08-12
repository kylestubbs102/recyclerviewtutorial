package com.example.recyclerviewtutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ClickedFragment : Fragment() {

    private var param1: Int? = null

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // if arguments is null, then it doesn't run
        arguments?.let {
            param1 = it.getInt(PARAM1_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_clicked, container, false)

        textView = view.findViewById(R.id.text_view_clicked_fragment)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textView.text = "You clicked on row $param1"
    }

    // everything in here is static
    companion object {
        // I think you only need JvmStatic so Java can read this method
        @JvmStatic
        fun newInstance(value: Int) =
            ClickedFragment().apply {
                arguments = Bundle().apply {
                    putInt(PARAM1_KEY, value)
                }
            }

        private const val PARAM1_KEY = "param_key"
    }
}