package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.ActivityAlertInfoBinding
import com.example.carrotmarket.databinding.FragmentMyBinding

class Alert_info_activity : AppCompatActivity() {
    lateinit var binding: ActivityAlertInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlertInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backButtonAlert.setOnClickListener {
            finish()
        }

    }
}