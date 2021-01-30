package com.demo.ui.viewModule

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.api.Resource
import com.demo.ui.Repository.CurrencyRepo
import java.text.DecimalFormat

class CurrencyViewModule @ViewModelInject constructor(
    private val localDataSource: CurrencyRepo
) : ViewModel() {
    private val currencyValue = MutableLiveData<HashMap<String, Double>>()
    val currencyKey = MutableLiveData<List<String>>()
    val selectKey: MutableLiveData<String> = MutableLiveData()

    private val decimalFormat = DecimalFormat("###,###.##")

    val amount = MutableLiveData<String>()
    val result = MutableLiveData<String>()
    fun loadData(lifecycleOwner: LifecycleOwner) {
        localDataSource.getCurrencyLocal().observe(lifecycleOwner, {
            when (it.status) {
                Resource.Status.LOADING -> {
                }
                Resource.Status.SUCCESS -> {
                    it.data?.quotes?.let {m->
                        currencyValue.value = m
                        currencyKey.value = m.keys.toList()

                    }
                }
                Resource.Status.ERROR -> {
                }
            }
        })
        amount.observe(lifecycleOwner, {
            currencyUpdate(selectKey.value, it)

        })



    }

    private fun currencyUpdate(key: String?, value: String?) {
        value?.let {
            result.value  = if (it.isNotBlank() && it != "." && !key.isNullOrEmpty() && !currencyValue.value.isNullOrEmpty()) decimalFormat.format(it.toDouble() * this.currencyValue.value?.get(key)!!) else "0"
        }
    }

    fun onItemSelect(key: Any?) {
        (key as String).also {
            selectKey.value = it
            currencyUpdate(it,amount.value)
        }
    }


}