package com.example.marsroverphotos.util

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.marsroverphotos.R
import kotlinx.coroutines.ExperimentalCoroutinesApi


class ImageUtils {

    companion object{
        const val DEFAULT_RECIPE_IMAGE = R.drawable.mars_empty

    }

    @SuppressLint("UnrememberedMutableState")
    @ExperimentalCoroutinesApi
    @Composable
    fun loadPicture(url: String, @DrawableRes defaultImage: Int): MutableState<Bitmap?> {

        val bitmapState: MutableState<Bitmap?> = mutableStateOf(null)

        // show default image while image loads
        Glide.with(LocalContext.current)
            .asBitmap()
            .load(defaultImage)
            .into(object : CustomTarget<Bitmap>() {
                override fun onLoadCleared(placeholder: Drawable?) { }
                override fun onResourceReady(
                    resource: Bitmap,
                    transition: Transition<in Bitmap>?
                ) {
                    bitmapState.value = resource
                }
            })

        // get network image
        Glide.with(LocalContext.current)
            .asBitmap()
            .load(url)
            .into(object : CustomTarget<Bitmap>() {
                override fun onLoadCleared(placeholder: Drawable?) { }
                override fun onResourceReady(
                    resource: Bitmap,
                    transition: Transition<in Bitmap>?
                ) {
                    bitmapState.value = resource
                }
            })

        return bitmapState
    }
}