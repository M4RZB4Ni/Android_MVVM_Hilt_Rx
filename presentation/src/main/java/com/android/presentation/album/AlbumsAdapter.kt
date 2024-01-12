package com.android.presentation.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.domain.model.Category
import com.android.presentation.album.AlbumsAdapter.AlbumViewHolder
import com.android.presentation.databinding.HolderAlbumBinding

/**
 * This class is responsible for converting each data entry [Category]
 * into [AlbumViewHolder] that can then be added to the AdapterView.
 *
 */
internal class AlbumsAdapter(val onAlbumClick: (List<Category>) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val albums: MutableList<Category> = ArrayList()

    /*
     * This method is called right when adapter is created &
     * is used to initialize ViewHolders
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderAlbumBinding = HolderAlbumBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return AlbumViewHolder(holderAlbumBinding)
    }

    /* It is called for each ViewHolder to bind it to the adapter &
     * This is where we pass data to ViewHolder
     * */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AlbumViewHolder).onBind(getItem(position))
    }

    private fun getItem(position: Int): Category = albums[position]

    /*
     * This method returns the size of collection that contains the items we want to display
     * */
    override fun getItemCount() = albums.size

    fun addData(categories: List<Category>) {
        this.albums.clear()
        this.albums.addAll(categories)
        notifyDataSetChanged()
    }

    inner class AlbumViewHolder(private val binding: HolderAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(category: Category) {
//            binding.holderAlbumTextView.text = category
//
//            itemView.setOnClickListener {
//                onAlbumClick.invoke(album)
//            }
        }
    }
}