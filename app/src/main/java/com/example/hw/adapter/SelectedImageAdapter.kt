package com.example.hw.adapter

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw.R
import com.example.hw.databinding.ItemSelectedGalleryBinding
import java.util.*


class SelectedImageAdapter : RecyclerView.Adapter<SelectedImageAdapter.ImageHolder>() {


    private val imageList = arrayListOf<Uri>()

    class ImageHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemSelectedGalleryBinding.bind(item)
        fun bind(mainImage: Uri) = with(binding) {
            imageSelectedRecycler.setImageURI(mainImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_selected_gallery, parent, false)
        return ImageHolder(view)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount() = imageList.size

    @SuppressLint("NotifyDataSetChanged")
    fun addImage(mainImage: ArrayList<Uri>) {
        this.imageList.addAll(mainImage)
        notifyDataSetChanged()
    }
}