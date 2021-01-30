package com.demo.api

import javax.inject.Inject

/**
 * Created by Musharib Ali on 30/1/21.
 * I.S.T Pvt. Ltd
 * musharib.ali@innobles.com
 */
class ApiHelperImpl @Inject constructor(private val apiService: ApiService): BaseDataSource() {
    suspend fun getCurrencyModel(param:HashMap<String,String>) = getResult { apiService.getCurrencyModel(param) }
}