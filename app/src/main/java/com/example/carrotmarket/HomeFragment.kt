package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.carrotmarket.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        //기능추가
        binding.item1Layout.setOnClickListener{
            val intent = Intent(requireContext(), Stuff_info_activity::class.java)
            startActivity(intent)
        }
        binding.ivAlarm.setOnClickListener{
            val intent = Intent(requireContext(), Alert_info_activity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

}
