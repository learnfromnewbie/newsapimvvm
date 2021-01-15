package com.example.basicapimvvm.repository

import android.util.Log
import com.example.basicapimvvm.data.api.NewsAPIService
import com.example.basicapimvvm.data.api.NewsResponse
import com.example.basicapimvvm.utils.Resource
import java.lang.Exception
import javax.inject.Inject

class MainRepository @Inject constructor (
    private val newsAPIService: NewsAPIService) {


    suspend fun getNews() : Resource<NewsResponse>{
        return try{
            val response = newsAPIService.getNews()
            if(response.isSuccessful){
                Log.d("API",response.message())
                Resource.Success(response.body()!!)
            }else{
                Log.d("API",response.message())
                Resource.Failure("เกิดข้อผิดพลาด")
            }
        }catch (e : Exception){
            Resource.Failure(e.message ?: "กรุณาตรวจสอบการเชื่อมต่ออินเทอร์เน็ต")
        }
    }


}