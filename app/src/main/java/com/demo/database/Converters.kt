package com.demo.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.collections.HashMap

/**
 * Created by Musharib Ali on 30/1/21.
 * I.S.T Pvt. Ltd
 * musharib.ali@innobles.com
 */
class Converters {
    @TypeConverter
    fun getUserInfoToString(someObjects: HashMap<String,Double>?): String? {
        return Gson().toJson(someObjects)
    }

    @TypeConverter
    fun fromUserInfoTimestamp(data: String?): HashMap<String,Double>? {

        if (data == null) {
            return HashMap()
        }
        val listType =
            object : TypeToken<HashMap<String, Double>>() {}.type
        return Gson().fromJson(data, listType)


    }
}