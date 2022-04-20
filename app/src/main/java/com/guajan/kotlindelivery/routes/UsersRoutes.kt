package com.guajan.kotlindelivery.routes

import com.guajan.kotlindelivery.models.ResponseHttp
import com.guajan.kotlindelivery.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UsersRoutes {

    @POST("users/create")
    fun register(@Body user: User):Call<ResponseHttp>
}