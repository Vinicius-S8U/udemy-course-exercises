package com.example.fragments_app

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class Fragment1 : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Toast.makeText(
            context, "Function onAttach() has been called", Toast.LENGTH_SHORT
        ).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(
            context, "Function onCreate() has been called", Toast.LENGTH_SHORT
        ).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(
            context, "Function onCreateView() has been called", Toast.LENGTH_SHORT
        ).show()
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(
            context, "Function onStart() has been called", Toast.LENGTH_SHORT
        ).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(
            context, "Function onPause() has been called", Toast.LENGTH_SHORT
        ).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(
            context, "Function onStop() has been called", Toast.LENGTH_SHORT
        ).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Toast.makeText(
            context, "Function onDestroyView() has been called", Toast.LENGTH_SHORT
        ).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(
            context, "Function onDestroy() has been called", Toast.LENGTH_SHORT
        ).show()
    }

    override fun onDetach() {
        super.onDetach()
        Toast.makeText(
            context, "Function onDetach() has been called", Toast.LENGTH_SHORT
        ).show()
    }
}