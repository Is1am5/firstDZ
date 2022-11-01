package com.example.hw.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw.R
import com.example.hw.databinding.ItemListBinding

class Adapter(private var listener: Listener) :
    RecyclerView.Adapter<Adapter.AdapterHolder>() {

    private val imageList = arrayListOf<Uri>()
    //Стандарт адаптера
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return AdapterHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        holder.bind(imageList[position], listener)
    }

    override fun getItemCount() = imageList.size


    class AdapterHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemListBinding.bind(item)

        fun bind(mainImage: Uri, listener: Listener) = with(binding) {
            image.setImageURI(mainImage)
            imageShadow.visibility = INVISIBLE
            itemView.setOnClickListener {
                if (!imageShadow.isVisible) {
                    listener.onClick(mainImage) //
                    imageShadow.visibility = VISIBLE
                } else  {
                    listener.deleteClick(mainImage)
                    imageShadow.visibility = INVISIBLE // Установка видимости
                }
            }
        }
    }

    //метод
    @SuppressLint("NotifyDataSetChanged")
    fun addImage(image: Uri) {
        this.imageList.addAll(listOf(image))
        notifyDataSetChanged()
    }

    //Интерфейс
    interface Listener {
        fun onClick(mainImage: Uri)
        fun deleteClick(mainImage: Uri)
    }
}