package com.example.carrotmarket.remote

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

data class SignUpRequest( //Request Body Data class
    @SerializedName("userId") val userId: String, //HTTP 통신과 요청 될때 해당 키값으로 통신한다. 따라서 키값과 동일한 String 넣어줘야 한다.
    @SerializedName("password") val password : String,
    @SerializedName("nickname") val nickname :String

    //"userId" : "kuit@konkuk.ac.kr",
    //"password" : "2023kuit!@#",
    //"nickname" : "yaho" -> API 명세서 Request의 값들임.

)
data class SignUpResponse( // Response Body Data class
    @SerializedName("userId") val userId: String
)
interface Apiservice{
    @POST("/your/store/endpoint")
    fun getStoreData(@Body request: SignUpRequest): Call<List<SignUpRequest>>

}