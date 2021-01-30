package com.demo.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.api.model.CurrencyModel

/**
 * Created by Musharib Ali on 30/1/21.
 * I.S.T Pvt. Ltd
 * musharib.ali@innobles.com
 */
@Dao
interface CurrencyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(currencyModel: CurrencyModel)

    @Query("Select * from currency_table")
    fun getCurrencyModule():LiveData<CurrencyModel>

//    @Query("Select quotes from currency_table ")
//    fun getCurrencyList():LiveData<HashMap<String,Double>>

}