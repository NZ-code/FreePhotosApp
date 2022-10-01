package nick.dev.gallery.network

import nick.dev.gallery.network.data.ResponseListOfPhotos
import nick.dev.gallery.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface PhotosApiService {
    @Headers("Authorization:${Constants.API_KEY}")
    @GET("/v1/search?query=apple")
    suspend fun getPhotosByWord(): Response<ResponseListOfPhotos>
}