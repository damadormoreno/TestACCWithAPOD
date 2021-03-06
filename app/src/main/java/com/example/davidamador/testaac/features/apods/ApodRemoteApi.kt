package com.example.davidamador.testaac.features.apods


import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface ApodRemoteApi {

    companion object Factory {
        fun create(): ApodRemoteApi {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.nasa.gov/planetary/")
                    .build()

            return retrofit.create(ApodRemoteApi::class.java)
        }
    }

    @GET("apod?api_key=DEMO_KEY")
    fun getApod() : Call<Apod>

    @GET("apod?api_key=DEMO_KEY")
    fun getRecentsApods(@Query("start_date") startDate: String,
                        @Query("end_date") endDate: String): Call<List<Apod>>

}