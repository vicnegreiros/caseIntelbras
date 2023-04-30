package com.negreiros.caseintelbras

import android.media.tv.AdResponse
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.negreiros.caseintelbras.models.Alarme
import com.negreiros.caseintelbras.rest.ClientApi
import com.negreiros.caseintelbras.rest.RetrofitService
import retrofit2.Retrofit
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity(){

    private lateinit var result: TextView

    private val clientApi = ClientApi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lateinit var apiService : RetrofitService



        apiService.getAlarmes().enqueue(object : Callback<List<Alarme>> {
            override fun onResponse(call: Call<List<Alarme>>, response: Response<List<Alarme>>) {
                // lógica para tratar a resposta da API
            }

            override fun onFailure(call: Call<List<Alarme>>, t: Throwable) {
                // lógica para tratar o erro de comunicação com a API
            }
        })



        val call = clientApi.getService().getAllAlarmes()
        call.enqueue(object : Callback<List<Alarme>> {
            override fun onResponse(call: Call<List<Alarme>>, response: Response<List<Alarme>>) {
                if (response.isSuccessful) {
                    val dados = response.body()
                    // Faça algo com os dados
                } else {
                    // Lidar com erros de resposta
                }
            }

            override fun onFailure(call: Call<List<Alarme>>, t: Throwable) {
                // Lidar com erros de rede
            }
        })







    }
}