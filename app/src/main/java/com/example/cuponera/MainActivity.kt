package com.example.cuponera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cuponera.model.Cupones
import com.example.cuponera.model.Offer
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private var listCupon = ArrayList<Offer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )
        loadList()
    }

    private fun loadList() {
        val apiKey = "944ad34600d2a52ae1c79a62ca340975"

        ApiService.create()
            .getTopRated(apiKey)
            .enqueue(object : Callback<Cupones> {

                override fun onFailure(call: Call<Cupones>, t: Throwable) {
                    Log.d("Error", t.message)
                }

                override fun onResponse(call: Call<Cupones>, response: Response<Cupones>) {
                    if (response.isSuccessful) {
                        listCupon = response.body()!!.offers as ArrayList<Offer>
                        val CuponesAdapter = CuponAdapter(listCupon)
                        recyclerView.adapter = CuponesAdapter
                    }
                }
            })

         }

}
