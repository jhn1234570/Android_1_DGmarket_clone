package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    var productAdapter: ProductAdapter? = null
    val productList: ArrayList<ProductEntity> = arrayListOf()
    var productDB : ProductDB? = null


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
        productDB = ProductDB.getInstance(requireContext())

        //기능추가
        return binding.root

    }


    // Fragment 생명 주기
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //IO Thread 에서 ProductEntity 데이터 가져오기
        CoroutineScope(Dispatchers.IO).launch { // coroutine이 onviewcreate에 생성된 이유는 차후 작업을 해야 하기 떄문이다?
            initDummyData()
            productDB?.let {
                val products = it.getProductDAO().GetAllMyString() //  Koltin Null 안정성 코드.
                withContext(Dispatchers.Main){
                    (binding.tradeUserList.adapter as ProductAdapter).setData(products)
                }
            }
        }
        attachProductAdapter()
    }

    private fun attachProductAdapter() {
        productAdapter = ProductAdapter(productList)
        binding.tradeUserList.adapter = productAdapter //ProductAdapter(datalist) - 7주차 미션
        binding.tradeUserList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)

        // TODO: 작성한 어댑터를 binding과 연결하고 layoutManager 등록하기


        // TODO : setOnItemClickListener에 제공할 인터페이스를 익명 클래스로 작성하고,  화면 클릭 이벤트 구현하기 
        productAdapter!!.setOnItemClickListener(object: ProductAdapter.OnItemClickListener{
            override fun onItemClick(productEntity: ProductEntity) {
//                Toast.makeText(context, productInfo.price, Toast.LENGTH_SHORT).show()
                val intent = Intent(requireContext(), StuffInfoActivity::class.java)
                intent.putExtra("information",productEntity)
                startActivity(intent)

            }

        })
    }

    // TODO: 각자 구성한 데이터 클래스에 맞게 더미 데이터를 구성해보기
    private fun initDummyData() {
        productDB?.let { // Koltin Null 안정성 코드.
            it.getProductDAO().addProduct( //GetProductDAO는 Product를 호출함. 그리고 AddProduct가 동작 수행
                ProductEntity (
                    title = "거래하실 1분 구합니다",
                    residence = "서울특별시 광진구 화양동",
                    price = "53,000원",
                    comment = "22",
                    like = "22"
                )
            )
        }
        productDB?.let {
            it.getProductDAO().addProduct(
                ProductEntity (
                    title = "빠른 거래 부탁합니다.",
                    residence = "경기도 하남시",
                    price = "43,000원",
                    comment = "12",
                    like = "27"
                )
            )
        }
        productDB?.let {
            it.getProductDAO().addProduct(
                ProductEntity (
                    title = "허위 매물 아닙니다.",
                    residence = "인천광역시 미추홀구",
                    price = "13,000원",
                    comment = "2",
                    like = "7"
                )
            )
        }
    }
}
