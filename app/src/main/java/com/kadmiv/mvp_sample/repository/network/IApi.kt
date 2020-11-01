package com.kadmiv.mvp_sample.repository.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Kadmiv on 01.11.2020 11:53
 */
interface IApi {

    @POST
    fun authorization(login: String, password: String): Call<ResponseBody>
}