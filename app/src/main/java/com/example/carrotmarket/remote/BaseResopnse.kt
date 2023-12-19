package com.example.carrotmarket.remote

import com.google.gson.annotations.SerializedName

data class BaseResopnse <T>( //응답이 성공하거나 실패하거나 같은 key값을 가지는 것을 모아놓은 것.
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : T // 특이하게 result 에는 String, Int, 심지어 객체가 들어 와도 된다. 제너릭(Generic)이라 명명
                                            // 회원가입과 로그인의 객체 정보가 다르기 때문이다. <T> 로 표현함.
)
