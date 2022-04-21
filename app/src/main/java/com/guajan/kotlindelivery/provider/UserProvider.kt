package com.guajan.kotlindelivery.provider

import com.guajan.kotlindelivery.api.ApiRoutes
import com.guajan.kotlindelivery.models.ResponseHttp
import com.guajan.kotlindelivery.models.User
import com.guajan.kotlindelivery.routes.UsersRoutes
import retrofit2.Call

class UserProvider {
private var usersRoutes:UsersRoutes?=null

    init{
        val api = ApiRoutes()
        usersRoutes = api.getUserRoutes()
    }

    fun register(user: User):Call<ResponseHttp>?{
        return usersRoutes?.register(user)
    }

    fun login(email: String, password: String):Call<ResponseHttp>?{
        return usersRoutes?.login(email, password)
    }
}