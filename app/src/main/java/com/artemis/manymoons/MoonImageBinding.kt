package com.artemis.manymoons



import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.google.firebase.storage.FirebaseStorage

object MoonImageBinding {


 @BindingAdapter("imageUrl")
   fun loadImage(imageView: ImageView, url: String){
        val storageRef = FirebaseStorage.getInstance().reference
        GlideApp.with(imageView.context)
            .load(storageRef)
            .into(imageView)
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
