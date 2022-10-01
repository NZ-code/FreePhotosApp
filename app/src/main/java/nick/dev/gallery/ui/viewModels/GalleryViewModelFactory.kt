package nick.dev.gallery.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import nick.dev.gallery.repository.GalleryRepository

class GalleryViewModelFactory constructor
    (private val repository: GalleryRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GalleryViewModel(repository) as T
    }
}