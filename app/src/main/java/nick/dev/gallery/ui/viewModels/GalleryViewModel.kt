package nick.dev.gallery.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nick.dev.gallery.network.Photo
import nick.dev.gallery.repository.GalleryRepository

class GalleryViewModel(private val respository:GalleryRepository):ViewModel(){
    val photos = MutableLiveData<List<Photo>>()
    fun getPhotosByWord(){
        viewModelScope.launch {
            val response = respository.getPhotosByName()
            photos.postValue( response.body()?.photos)

        }

    }
}