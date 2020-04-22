package com.example.cuponera


import com.example.cuponera.model.Cupones
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("getOffers/?format=json")
    //@Query("format") format: String
    fun getTopRated(@Query("API_KEY") apiKey: String): Call<Cupones>

    companion object{
        val urlAPI = "http://feed.linkmydeals.com/"



        fun create(): ApiService{

           /* val interceptor = HttpLoggingInterceptor()
            //interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        */
            val retrofit = Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())

                .build()

            return retrofit.create(ApiService::class.java)
        }
    }








}