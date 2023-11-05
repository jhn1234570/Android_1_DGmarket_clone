// 패키지 오류가 나는 경우 각자 프로젝트 명에 맞게 패키지 이름을 수정해주세요! 
package com.example.carrotmarket

import ProductInfo
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    var productAdapter: ProductAdapter? = null
    val productList: ArrayList<ProductInfo> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.tradeUserList.setOnClickListener {
            val intent = Intent(requireContext(), StuffInfoActivity::class.java)
            startActivity(intent)
        }

        binding.ivAlarm.setOnClickListener {
            val intent = Intent(requireContext(), AlertInfoActivity::class.java)
            startActivity(intent)
        }
        //기능추가
        return binding.root
    }


    // Fragment 생명 주기
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDummyData()
        attachProductAdapter()
    }

    private fun attachProductAdapter() {
        productAdapter = ProductAdapter(productList)
        binding.tradeUserList.adapter = productAdapter
        binding.tradeUserList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)

        // TODO: 작성한 어댑터를 binding과 연결하고 layoutManager 등록하기


        // TODO : setOnItemClickListener에 제공할 인터페이스를 익명 클래스로 작성하고,  화면 클릭 이벤트 구현하기 
        productAdapter!!.setOnItemClickListener(object: ProductAdapter.OnItemClickListener{
            override fun onItemClick(productInfo: ProductInfo) {
//                Toast.makeText(context, productInfo.price, Toast.LENGTH_SHORT).show()
                val intent = Intent(requireContext(), StuffInfoActivity::class.java)
                intent.putExtra("information",productInfo)
                startActivity(intent)

            }

        })
    }

    // TODO: 각자 구성한 데이터 클래스에 맞게 더미 데이터를 구성해보기
    private fun initDummyData() {
        productList.addAll(
            arrayListOf(
                ProductInfo("거래하실 1분 구합니다","서울특별시 광진구 화양동","53,000원","22","22"),
                ProductInfo("거래하실 2분 구합니다","건국대학교 앞","10,430원","11","11"),
                ProductInfo("거래하실 3분 구합니다","어린이대공원역","10,300원","12","22"),
                ProductInfo("거래하실 4분 구합니다","동대문역사박물관","12,000원","23","13"),
                ProductInfo("거래하실 5분 구합니다","강남 서초","20,000원","31","33"),
                ProductInfo("거래하실 6분 구합니다","부산 서면","40,000원","12","21")
            )
        )
    }


}