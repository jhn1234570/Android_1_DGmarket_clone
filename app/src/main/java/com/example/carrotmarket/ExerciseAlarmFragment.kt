package com.example.carrotmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carrotmarket.databinding.FragmentExerciseAlarmBinding

class ExerciseAlarmFragment : Fragment() {
    private lateinit var binding: FragmentExerciseAlarmBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExerciseAlarmBinding.inflate(inflater,container,false)
        return binding.root
    }

}