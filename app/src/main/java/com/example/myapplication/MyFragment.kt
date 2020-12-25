package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.util.Log

class MyFragment : Fragment(R.layout.my_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.myFragment).text =
            arguments?.getInt(pmFragmentParametr).toString()
    }

    companion object {
        const val pmFragmentParametr = "pmFragmentParametr"

        fun newInstance(result: Int): MyFragment {
            val myfragment = MyFragment()
            val bundle = Bundle()
            bundle.putInt(pmFragmentParametr, result)
            myfragment.arguments = bundle
            return myfragment
        }
    }
}
