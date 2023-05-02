package com.artemis.manymoons

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object MoonImageBinding {
   @JvmStatic @BindingAdapter("imageUrl")
    fun loadImage(imageView: ImageView, url: String) {
        if (url != "") {
            Picasso.get().load(url).resize(200, 200).into(imageView)
        }
    }
}

/*
object BindingImages{
    @BindingAdapter("android:image")
    fun loadImage(imageView: ImageView, url: String) {
        if (url != "") {
            Picasso.get().load(url).resize(200, 200).into(imageView)
        }
    }
}*/
