package com.example.carrotmarket.remote


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitInterface {
    @POST("users/signup") //API 명세서에서 annotation이 POST였음
    fun signup(            // 이곳에 request body가 들어가고 응답이 와야 한다.
        @Body request: SignUpRequest // 데이터 타입을 아까 만든 데이터 클래스 가져와서 사용
    ) : Call<BaseResopnse<SignUpResponse>> // request의 응답을 Call 객체로 반환. Call을 import 할 때 retrofit 관련 클래스 임포트 해야함
}