package com.artemis.manymoons

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import kotlinx.parcelize.Parcelize

@Parcelize
data class MoonMenuX(
    val moon_des: String ?= null,
    val moon_name: String ?= null,
    val moon_image: String ?= null
): Parcelable

