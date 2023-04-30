package com.negreiros.caseintelbras.rest

import com.negreiros.caseintelbras.models.Alarme
import com.negreiros.caseintelbras.models.DVR
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("alarm-centrals")
    fun getAllAlarmes(): Call<List<Alarme>>

    @GET("video-devices")
    fun getAllDVR(): Call<List<DVR>>

    

}