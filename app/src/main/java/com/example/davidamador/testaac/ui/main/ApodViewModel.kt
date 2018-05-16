package com.example.davidamador.testaac.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.davidamador.testaac.data.ApodRepository
import com.example.davidamador.testaac.ui.models.Apod

class ApodViewModel : ViewModel() {

    var apod: LiveData<Apod>? = null
    private val apodRepository = ApodRepository()

    fun init() {
        apod = apodRepository.getRemoteApod()
    }


}
