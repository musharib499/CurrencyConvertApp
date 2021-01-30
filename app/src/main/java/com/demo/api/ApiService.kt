package com.demo.api

import com.demo.api.model.CurrencyModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by Musharib Ali on 30/1/21.
 * I.S.T Pvt. Ltd
 * musharib.ali@innobles.com
 */
interface ApiService {

    @GET("live")
    suspend fun getCurrencyModel(@QueryMap param:HashMap<String,String>): Response<CurrencyModel>
}