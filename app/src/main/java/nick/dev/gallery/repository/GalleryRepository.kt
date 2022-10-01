package nick.dev.gallery.repository

import nick.dev.gallery.network.PhotosApi
import nick.dev.gallery.network.PhotosApiService

class GalleryRepository constructor(private val photosApiService:PhotosApiService) {
    suspend fun getPhotosByName() = photosApiService.getPhotosByWord()
}