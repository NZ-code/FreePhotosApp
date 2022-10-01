package nick.dev.gallery.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL = "https://api.pexels.com"
object RetrofitClient {
    fun getInstance(): Retrofit =Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}
