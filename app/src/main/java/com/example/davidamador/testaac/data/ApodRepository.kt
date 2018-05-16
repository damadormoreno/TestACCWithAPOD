package com.example.davidamador.testaac.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.davidamador.testaac.ui.models.Apod
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApodRepository {

    val apodApi = ApodRemoteApi.create()

    fun getRemoteApod() : LiveData<Apod> {

        val data: MutableLiveData<Apod> = MutableLiveData()

        apodApi.getApod().enqueue(object : Callback<Apod>{
            override fun onFailure(call: Call<Apod>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<Apod>?, response: Response<Apod>?) {
                data.value = response?.body()
            }
        })

        return data
    }
}