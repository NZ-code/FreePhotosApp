package nick.dev.gallery.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import nick.dev.gallery.databinding.ActivityMainBinding
import nick.dev.gallery.databinding.ImageItemBinding
import nick.dev.gallery.network.Photo

class ImageAdapter :RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    inner class ImageViewHolder(val binding: ImageItemBinding):RecyclerView.ViewHolder(binding.root)

    private val differCallback = object :DiffUtil.ItemCallback<Photo>(){
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }

    }
    var differ =AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =ImageItemBinding.inflate(layoutInflater,parent,false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val photo = differ.currentList[position]
        holder.binding.apply {

            ivPhoto.load(photo.src.large)
            tvName.text = photo.alt
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}