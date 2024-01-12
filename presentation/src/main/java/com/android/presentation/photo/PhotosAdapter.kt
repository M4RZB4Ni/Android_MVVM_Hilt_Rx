package com.android.presentation.photo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.domain.model.Product
import com.android.presentation.databinding.HolderPhotoBinding


internal class PhotosAdapter(val onPhotoClick: (Int) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val products: MutableList<Product> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderPhotoBinding = HolderPhotoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PhotoViewHolder(holderPhotoBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PhotoViewHolder).onBind(getItem(position))
    }

    private fun getItem(position: Int): Product = products[position]

    override fun getItemCount(): Int = products.size

    fun addData(list: List<Product>) {
        this.products.clear()
        this.products.addAll(list)
        notifyDataSetChanged()
    }

    inner class PhotoViewHolder(private val binding: HolderPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(product: Product) {
            with(binding) {
                photoProgressBar.visibility = View.VISIBLE
                photoTextView.text = product.title
//                photoImageView.loadImage(product.images!![0], binding.photoProgressBar)
            }

            itemView.setOnClickListener {
                onPhotoClick(product.id)
            }
        }
    }
}
