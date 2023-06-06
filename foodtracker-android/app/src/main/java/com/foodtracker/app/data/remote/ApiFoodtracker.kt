package com.foodtracker.app.data.remote

import com.foodtracker.app.domain.model.*
import retrofit2.Response
import retrofit2.http.*

interface ApiFoodtracker {

    @POST("signUp")
    suspend fun registration(@Body body: UserCreate): Response<Token>

    @POST("signIn")
    suspend fun login(@Body body: UserLogin): Response<Token>

    @POST("/user/getById")
    suspend fun getUserById(
        @Header("Authorization") token: String?,
        @Body getUser: GetUser
    ): Response<User>

    @POST("/user/update")
    suspend fun updateUser(
        @Header("Authorization") token: String?,
        @Body user: User
    )

    @POST("/user/updatePassword")
    suspend fun updatePassword(
        @Header("Authorization") token: String?,
        @Body user: User
    )

    @GET("/product/getAll")
    suspend fun getProducts(
        @Header("Authorization") token: String?
    ): Response<List<ProductItem>>

    @GET("/product/getById")
    suspend fun getProductById(
        @Header("Authorization") token: String?,
        @Path("id") id: String
    ): Response<ProductItem>

    @POST("/dailyProgress/getByDate")
    suspend fun getDailyProgressByDate(
        @Header("Authorization") token: String?,
        @Body getDailyProgress: GetDailyProgress
    ): Response<DailyProgress>

    @POST("/dailyProgress/insert")
    suspend fun createDailyProgress(
        @Header("Authorization") token: String?,
        @Body createDailyProgress: CreateDailyProgress
    )
}
