package com.example.gallery.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.GalleryItem
import com.example.gallery.databinding.ItemGalleryBinding

class GalleryAdapter: ListAdapter<GalleryItem,GalleryAdapter.GalleryHolder>(GalleryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryHolder {
        return GalleryHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GalleryHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class GalleryHolder private constructor(binding: ItemGalleryBinding): RecyclerView.ViewHolder(binding.root){

        companion object{
            fun from(parent: ViewGroup): GalleryHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemGalleryBinding.inflate(layoutInflater)
                return GalleryHolder(binding)
            }
        }
    }

    class GalleryDiffCallback: DiffUtil.ItemCallback<GalleryItem>(){
        override fun areItemsTheSame(oldItem: GalleryItem, newItem: GalleryItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GalleryItem, newItem: GalleryItem): Boolean {
            return oldItem == newItem
        }
    }
}