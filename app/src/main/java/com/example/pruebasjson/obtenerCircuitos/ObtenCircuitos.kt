package com.example.pruebasjson.obtenerCircuitos

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://ergast.com/api/f1/2010/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface ObtenerCircuitos {
    @GET("circuits.json")
    suspend fun getPhotos(): String
}
object CircuitosAPI {
    val retrofitService : ObtenerCircuitos by lazy {
        retrofit.create(ObtenerCircuitos::class.java) }
}
class ObtenCircuitos {



}