package nick.dev.gallery.network



object PhotosApi {
    val retrofit:PhotosApiService by lazy {
        RetrofitClient.getInstance().create(PhotosApiService::class.java)
    }
}