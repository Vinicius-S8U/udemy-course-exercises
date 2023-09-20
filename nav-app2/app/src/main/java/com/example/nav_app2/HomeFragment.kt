package com.example.nav_app2

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.nav_app2.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)


        binding.homeBtnSubmit.setOnClickListener {
            if (!TextUtils.isEmpty(binding.homeEt.text.toString())) {
                val bundle = bundleOf("name" to binding.homeEt.text.toString())

                it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment, bundle)
            } else {
                Toast.makeText(activity, "Don't forget to enter your name", Toast.LENGTH_LONG)
                    .show()
            }
        }

        return binding.root
    }
}