package nick.dev.gallery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import nick.dev.gallery.R
import nick.dev.gallery.databinding.ActivityMainBinding
import nick.dev.gallery.network.PhotosApi
import nick.dev.gallery.network.RetrofitClient
import nick.dev.gallery.repository.GalleryRepository
import nick.dev.gallery.ui.adapters.ImageAdapter
import nick.dev.gallery.ui.viewModels.GalleryViewModel
import nick.dev.gallery.ui.viewModels.GalleryViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var viewModel:GalleryViewModel
    lateinit var binding: ActivityMainBinding
    lateinit var imageAdapter: ImageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofit = PhotosApi.retrofit
        val repository = GalleryRepository(retrofit)
        viewModel = ViewModelProvider(this, GalleryViewModelFactory(repository))[GalleryViewModel::class.java]

        imageAdapter = ImageAdapter()

        binding.btnEnter.setOnClickListener {
            val word = binding.etWord.text.toString()
            viewModel.getPhotosByWord(word)
        }

        viewModel.photos.observe(this){
            imageAdapter.differ.submitList(it)
        }
        setUpRecyclerView()
    }
    private fun setUpRecyclerView(){
        val rvImages = binding.rvImages
        rvImages.apply {
            layoutManager =LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = imageAdapter

        }
    }
}