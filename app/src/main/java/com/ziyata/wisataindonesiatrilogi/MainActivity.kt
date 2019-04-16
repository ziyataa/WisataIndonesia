package com.ziyata.wisataindonesiatrilogi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurasi retrofit
        val retrofit = Retrofit.Builder()
                .baseUrl("http://udacoding.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // Insert config ke interface request
        val request = retrofit.create(WisataService::class.java)

        //Response server
        request.requestAmbil().enqueue(object : Callback<ResponseServer>{
            override fun onFailure(call: Call<ResponseServer>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<ResponseServer>?, response: Response<ResponseServer>) {
                Log.d("response server", response.body()?.message)

                showData(response.body()?.data)
            }
        })

    }

    private fun showData(data: List<DataWisata>?) {
        list.adapter = data?.let { WisataAdapter(it) }
    }

}
