package com.example.davidamador.testaac.features.apods

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

class ApodListViewModel : ViewModel() {

    var apod: LiveData<Apod>? = null
    var apodlist : LiveData<List<Apod>>? = null
    private val apodRepository = ApodRepository()

    fun init() {
        apod = apodRepository.getRemoteApod()
        apodlist = apodRepository.getRemoteListApod("2018-04-12", "2018-05-17")
    }


}
