package com.android.presentation

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar

import coil.load
import coil.request.ImageRequest
import coil.request.SuccessResult

fun ImageView.loadImage(url: String?) = this.load(url)

fun ImageView.loadImage(url: String, progressBar: ProgressBar) = this.load(url) {
    crossfade(true)
    listener(object : ImageRequest.Listener {
        override fun onSuccess(request: ImageRequest, result: SuccessResult) {
            super.onSuccess(request, result)
            progressBar.visibility = View.GONE
        }
    })
}
