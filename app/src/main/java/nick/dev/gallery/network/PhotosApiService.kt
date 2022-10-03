package nick.dev.gallery.network

import nick.dev.gallery.network.data.ResponseListOfPhotos
import nick.dev.gallery.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PhotosApiService {
    @Headers("Authorization:${Constants.API_KEY}")

    //@GET("/v1/search?query=apple")
    @GET("/v1/search?")
    suspend fun getPhotosByWord(@Query("query") query:String): Response<ResponseListOfPhotos>
}