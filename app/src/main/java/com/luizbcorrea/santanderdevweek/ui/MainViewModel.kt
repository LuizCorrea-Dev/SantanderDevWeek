package com.luizbcorrea.santanderdevweek.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.luizbcorrea.santanderdevweek.data.Conta
import com.luizbcorrea.santanderdevweek.data.local.FakeData

class MainViewModel : ViewModel(){

    // recebe os dados para ser observado no futuro
    private val mutableListData: MutableLiveData<Conta> = MutableLiveData()

    fun buscarContaCliente() : LiveData<Conta> {
        mutableListData.value = FakeData().getLocalData()
        return mutableListData
    }
}