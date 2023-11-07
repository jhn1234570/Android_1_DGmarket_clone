// 패키지 오류가 나는 경우 각자 프로젝트 명에 맞게 패키지 이름을 수정해주세요! 
package com.example.carrotmarket

import ProductInfo
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
    val productList: ArrayList<ProductInfo> = arrayListOf()
//    var productDatabase : ProductDB? = null
//    var productDB : ProductDB? = null

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

//        CoroutineScope(Dispatchers.IO).launch { // coroutine이 onviewcreate에 생성된 이유는 차후 작업을 해야 하기 떄문이다?
//            //initDummyData() 들어가는 자리
//            val products = productDB!!.GetProductDAO().AddProduct()
//            withContext(Dispatchers.Main){
//                (binding.tradeUserList.adapter as ProductAdapter).setData(products)
//            }
//        }
        initDummyData()
        attachProductAdapter()
    }

    private fun attachProductAdapter() {
        productAdapter = ProductAdapter(productList)
        binding.tradeUserList.adapter = productAdapter //ProductAdapter(datalist) - 7주차 미션
        binding.tradeUserList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)

        // TODO: 작성한 어댑터를 binding과 연결하고 layoutManager 등록하기


        // TODO : setOnItemClickListener에 제공할 인터페이스를 익명 클래스로 작성하고,  화면 클릭 이벤트 구현하기 
        productAdapter!!.setOnItemClickListener(object: ProductAdapter.OnItemClickListener{
            override fun onItemClick(productEntity: ProductInfo) {
//                Toast.makeText(context, productInfo.price, Toast.LENGTH_SHORT).show()
                val intent = Intent(requireContext(), StuffInfoActivity::class.java)
                intent.putExtra("information",productEntity)
                startActivity(intent)

            }

        })
    }

    // TODO: 각자 구성한 데이터 클래스에 맞게 더미 데이터를 구성해보기
    private fun initDummyData() {
//        productDB!!.GetProductDAO().AddProduct( //GetProductDAO는 Product를 호출함. 그리고 AddProduct가 동작 수행
        productList.addAll(
            arrayListOf( //대신 다른 함수로 교체 ->> 제거하고 AddProduct가 데이터 삽입하는 역할
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