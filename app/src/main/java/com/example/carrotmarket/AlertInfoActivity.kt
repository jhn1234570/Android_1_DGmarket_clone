package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.ActivityAlertInfoBinding
import com.google.android.material.tabs.TabLayoutMediator

class AlertInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlertInfoBinding
    private var tabList = arrayListOf("활동 알림", "키워드 알림")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlertInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        binding.backButtonAlert.setOnClickListener {
            finish()
        }


}

    private fun initView() {
        binding.alertListVp.adapter = TabLayoutVPAdapter(this)

        TabLayoutMediator(binding.alertWordTb,binding.alertListVp){tab,position ->
            tab.text = tabList[position]
        }.attach()
    }
}