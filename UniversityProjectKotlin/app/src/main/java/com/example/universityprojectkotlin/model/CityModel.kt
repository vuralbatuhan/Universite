package com.example.universityprojectkotlin.model


data class CityModel(
    val currentPage: Int,
    val totalPage: Int,
    val total: Int,
    val itemPerPage: Int,
    val pageSize: Int,
    val data: List<CityData>
)

data class CityData(
    val id: Int,
    val province: String,
    val universities: List<University>
)

data class University(
    val name: String,
    val phone: String,
    val fax: String,
    val website: String,
    val email: String,
    val adress: String,
    val rector: String
)
