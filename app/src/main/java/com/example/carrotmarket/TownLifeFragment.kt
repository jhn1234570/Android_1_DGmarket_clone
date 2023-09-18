package com.example.carrotmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.carrotmarket.databinding.FragmentTownlifeBinding

class TownLifeFragment : Fragment() {
    lateinit var binding : FragmentTownlifeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTownlifeBinding.inflate(layoutInflater)
        return binding.root
    }
}