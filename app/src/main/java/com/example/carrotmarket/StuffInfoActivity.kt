// 패키지 오류가 나는 경우 각자 프로젝트 명에 맞게 패키지 이름을 수정해주세요!
package com.example.carrotmarket

import ProductInfo
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding
//import com.example.kuit2_android.ProductAdapter


class StuffInfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityStuffInfoBinding
    private val imgList = mutableListOf<String>()
    private val pagerHandler = Handler(Looper.getMainLooper())
    private val imageSwiper = ImageSwiper()
    val thread = Thread(imageSwiper)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStuffInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.ivBackButton.setOnClickListener {
            finish()
        }
        val data =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getSerializableExtra("information", ProductInfo::class.java)
            } else {
                intent.getSerializableExtra("key") as ProductInfo // 7주차 ->> ProductEntity 로 바꾸기
            } ?: ProductInfo("null", "null", "null", "0","0")
        binding.tradeTitle.text = data.title
        binding.tvLocation.text = data.residence

//        initView()
        initDummydata()
        initViewPager()

        thread.start()
    }
    inner class ImageSwiper : Runnable{
        override fun run(){
            try {
                while (true){
                    Thread.sleep(3000)

                    pagerHandler.post{
                        var position = binding.computerLayout.currentItem
                        if (position==2){
                            position=0
                        } else{
                            position++
                        }

                        binding.computerLayout.currentItem = position
                    }
                }
            }catch (e: InterruptedException){
                Log.d("INTERRUPT","쓰레드 종료")
                Thread.currentThread().interrupt()
            }
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        thread.interrupt()
    }

    private fun initViewPager() {
        binding.computerLayout.adapter = ImageSliderVPAdapter(applicationContext,imgList)
        binding.computerLayout.orientation = ViewPager2.ORIENTATION_HORIZONTAL

    }
    private fun initDummydata() {
        imgList.add("https://cdn.pixabay.com/photo/2016/11/22/21/26/notebook-1850613_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2017/06/20/23/15/coffee-2425303_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2015/09/04/23/28/wordpress-923188_1280.jpg")

    }



//    private fun initView(data: String?) {
//        if (data == null) {
//            finish()
//            return
//        }
//        productAdapter = ProductAdapter()
//
//
//        // TODO: 받은 데이터를 StuffInfoActivity의 해당하는 View에 적용해보기
//
//    }
}