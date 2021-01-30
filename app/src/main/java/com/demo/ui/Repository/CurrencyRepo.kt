package com.demo.ui.Repository

import com.demo.api.ApiHelperImpl
import com.demo.api.loadData
import com.demo.database.CurrencyDao
import javax.inject.Inject

/**
 * Created by Musharib Ali on 27/1/21.
 * I.S.T Pvt. Ltd
 * musharib.ali@innobles.com
 */
class CurrencyRepo @Inject constructor(private val remoteDataSource: ApiHelperImpl, private val localDataSource: CurrencyDao) {

    fun getCurrency(param:HashMap<String,String>) = loadData(databaseQuery = {localDataSource.getCurrencyModule()},networkCall = {remoteDataSource.getCurrencyModel(param)},saveCallResult = {localDataSource.insert(it)})
    fun getCurrencyLocal() = loadData(databaseQuery = {localDataSource.getCurrencyModule()})

}