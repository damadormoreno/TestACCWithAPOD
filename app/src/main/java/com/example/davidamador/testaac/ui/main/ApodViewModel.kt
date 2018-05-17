package com.example.davidamador.testaac.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.davidamador.testaac.data.ApodRepository
import com.example.davidamador.testaac.ui.models.Apod

class ApodViewModel : ViewModel() {

    var apod: LiveData<Apod>? = null
    var apodlist : LiveData<List<Apod>>? = null
    private val apodRepository = ApodRepository()

    fun init() {
        apod = apodRepository.getRemoteApod()
        apodlist = apodRepository.getRemoteListApod("2018-04-12", "2018-05-17")
    }


}
