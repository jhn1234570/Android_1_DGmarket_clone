package com.example.carrotmarket

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.carrotmarket.remote.XAccessTokenintercepter
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//Retrofit builder 준비 완료
class ApplicationClass: Application() {
    companion object{ //Class에 포함되어있는 오브젝트
        const val DEV_URL : String ="http://13.125.254.172:23899"  // 개발 URL과
        const val PROD_URL : String = "http://kuit_prod_url"  // 배포 URL 나눔 -> 미리 배포하고 추가로 개발중인 코드 업데이트하기 위함

        const val BASE_URL : String = DEV_URL

        lateinit var retrofit : Retrofit // 지금 초기화 안시킴. 후에 작성할 함수에서 초기화 시켜줘야 함
        lateinit var mSharedPreferences: SharedPreferences
    }
    val client: OkHttpClient = OkHttpClient.Builder()
        .readTimeout(300000,TimeUnit.MILLISECONDS)
        .connectTimeout(30000,TimeUnit.MILLISECONDS)
        .addNetworkInterceptor(XAccessTokenintercepter()) // 중간에 데이터 탈취함. JWT 자동 헤더 전송
        .build()

    override fun onCreate() {
        super.onCreate()

        retrofit = Retrofit.Builder() // 초기화 여기서 해줌
            .baseUrl(BASE_URL)
            .client(client) // client를 retrofit 객체에 넣어줌
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        mSharedPreferences = applicationContext.getSharedPreferences("My App Sdp", Context.MODE_PRIVATE)
    }
}