package com.artemis.manymoons


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.net.URI

@Parcelize
data class MoonMenuX(
    val moon_des: String ?= null,
    val moon_name: String ?= null,
    val moon_image: String ?= null
): Parcelable

