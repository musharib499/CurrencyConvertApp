package com.demo.api.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.demo.database.Converters

@Entity(tableName = "currency_table")
data class CurrencyModel(
    @SerializedName("privacy")
    var privacy: String?, // https://currencylayer.com/privacy

    @TypeConverters(Converters::class)
    @SerializedName("quotes")
    var quotes: HashMap<String,Double>,

    @SerializedName("source")
    var source: String?, // USD
    @SerializedName("success")
    var success: Boolean?, // true
    @SerializedName("terms")
    var terms: String?, // https://currencylayer.com/terms
    @SerializedName("timestamp")
    var timestamp: Int? // 1611627066
){
    @PrimaryKey
    var id: Int = 0

}