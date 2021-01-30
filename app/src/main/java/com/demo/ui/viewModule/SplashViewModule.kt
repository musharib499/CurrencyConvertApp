package com.demo.ui.viewModule

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.BuildConfig
import com.demo.api.LoadingState
import com.demo.api.Resource
import com.demo.ui.Repository.CurrencyRepo

/**
 * Created by Musharib Ali on 14/1/21.
 * I.S.T Pvt. Ltd
 * musharib.ali@innobles.com
 */
class SplashViewModule @ViewModelInject constructor(private val repo: CurrencyRepo) : ViewModel() {
    private val _loading = MutableLiveData<LoadingState>()
    val loading: LiveData<LoadingState> get() = _loading
    private val _moveNext = MutableLiveData<Boolean>()
    val moveNext: LiveData<Boolean> get() = _moveNext

    fun loadData(lifecycleOwner: LifecycleOwner){
            val  param = HashMap<String,String>()
            param["access_key"] = BuildConfig.API_KEY
            param["source"] = "USD"
            repo.getCurrency(param).observe(lifecycleOwner, {
                when (it.status) {
                    Resource.Status.LOADING -> {
                        _loading.postValue(LoadingState.LOADING)
                    }
                    Resource.Status.SUCCESS -> {
                        _loading.postValue(LoadingState.LOADED)
                        it.data?.let {_moveNext.value = true}
                    }
                    Resource.Status.ERROR -> {
                        _loading.postValue(LoadingState.error(it.message))

                    }

                }
            })

}




}