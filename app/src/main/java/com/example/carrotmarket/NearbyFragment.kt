package com.example.carrotmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.carrotmarket.databinding.FragmentNearbyBinding

class NearbyFragment : Fragment() {
    lateinit var binding : FragmentNearbyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNearbyBinding.inflate(layoutInflater)
        return binding.root
    }
}