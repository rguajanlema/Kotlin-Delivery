package com.guajan.kotlindelivery.api

import com.guajan.kotlindelivery.routes.UsersRoutes

class ApiRoutes {
    val API_URL = "http://192.168.1.10:3000/api/"
    val retrofit = RetrofitClient()

    fun getUserRoutes(): UsersRoutes{
        return retrofit.getClient(API_URL).create(UsersRoutes::class.java)
    }
}