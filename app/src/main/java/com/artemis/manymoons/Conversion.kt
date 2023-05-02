package com.artemis.manymoons

import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter


/*@BindingAdapter("progressColor")
fun setProgressBarColor(loader: ProgressBar?, color: Int) {
    loader?.indeterminateDrawable?.setColorFilter(color, PorterDuff.Mode.SRC_IN)
}*/

/*import androidx.databinding.BaseObservable
import androidx.databinding.Bindable


class Cat(private var name: String, private var imageUrl: String) : BaseObservable() {
    @Bindable
    fun getName(): String {
        return name
    }

    @Bindable
    fun setName(name: String) {
        this.name = name
        notifyPropertyChanged(info.devexchanges.picassodatabinding.BR.name)
    }

    @Bindable
    fun getImageUrl(): String {
        return imageUrl
    }

    @Bindable
    fun setImageUrl(imageUrl: String) {
        this.imageUrl = imageUrl
        notifyPropertyChanged(info.devexchanges.picassodatabinding.BR.imageUrl)
    }
}*/

/*fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    //creating binding object
    val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    //creating model object
    val user = User()

    //binding the data
    binding.setUser(user)

    //reading data from firebase database
    FirebaseDatabase.getInstance().getReference("user")
        .addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                user.setName(dataSnapshot.child("name").getValue(String::class.java))
                user.setAddress(dataSnapshot.child("address").getValue(String::class.java))
                user.setEmail(dataSnapshot.child("email").getValue(String::class.java))
                user.setImage(dataSnapshot.child("image").getValue(String::class.java))
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
}*/


/*class User(val name: String, val address: String, val email: String)*/

/*class User : BaseObservable() {
    @get:Bindable
    var name: String? = null
        set(name) {
            field = name
            notifyPropertyChanged(BR.name)
        }

    @get:Bindable
    var address: String? = null
        set(address) {
            field = address
            notifyPropertyChanged(BR.address)
        }

    @get:Bindable
    var email: String? = null
        set(email) {
            field = email
            notifyPropertyChanged(BR.email)
        }
}*/

/*class User : BaseObservable() {
    @get:Bindable
    var name: String? = null
        set(name) {
            field = name
            notifyPropertyChanged(BR.name)
        }

    @get:Bindable
    var address: String? = null
        set(address) {
            field = address
            notifyPropertyChanged(BR.address)
        }

    @get:Bindable
    var email: String? = null
        set(email) {
            field = email
            notifyPropertyChanged(BR.email)
        }

    @get:Bindable
    @set:Bindable
    var image: String? = null
        set(image) {
            field = image
            notifyPropertyChanged(BR.image)
        }

    companion object {
        @BindingAdapter("android:image")
        fun loadImage(imageView: ImageView?, image: String?) {
            Glide.with(imageView)
                .load(image)
                .into(imageView)
        }
    }
}*/
