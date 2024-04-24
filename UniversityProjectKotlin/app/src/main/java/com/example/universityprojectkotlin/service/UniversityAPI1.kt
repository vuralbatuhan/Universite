package com.example.universityprojectkotlin.service

import com.example.universityprojectkotlin.model.CityModel
import retrofit2.Call
import retrofit2.http.GET

interface UniversityAPI1 {

    @GET("page-1.json")
    fun getUniversity(): Call<CityModel>



}