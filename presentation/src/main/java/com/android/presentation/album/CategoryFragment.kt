package com.android.presentation.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.android.domain.model.Category
import com.android.presentation.R
import com.android.presentation.databinding.FragmentAlbumsBinding
import com.android.presentation.photo.PhotosFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentAlbumsBinding
    private var adapter: AlbumsAdapter? = null
    private val viewModel: CategoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumsBinding.inflate(inflater, container, false)
        adapter = AlbumsAdapter { navigateToPhotosPage(it) }
        binding.albumsRecyclerView.adapter = adapter
        viewModel.loadAlbums()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {
            isLoad.observe(viewLifecycleOwner) {
                it?.let { visibility ->
                    binding.albumsProgressBar.visibility =
                        if (visibility) View.GONE else View.VISIBLE
                }
            }

            categoriesReceivedLiveData.observe(viewLifecycleOwner) {
                it?.let {
                    adapter?.addData(it)
                }
            }
        }
    }

    private fun navigateToPhotosPage(category: Category) {
        activity?.supportFragmentManager?.beginTransaction()?.replace(
            R.id.gallery_container,
            PhotosFragment.newInstance(category.id),
            PhotosFragment.FRAGMENT_NAME
        )?.addToBackStack(PhotosFragment.FRAGMENT_NAME)?.commitAllowingStateLoss()
    }

    override fun onDetach() {
        super.onDetach()
        adapter = null
    }

    companion object {
        val FRAGMENT_NAME: String = CategoryFragment::class.java.name

        @JvmStatic
        fun newInstance() = CategoryFragment()
    }
}
