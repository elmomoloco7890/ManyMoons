package com.artemis.manymoons

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.artemis.manymoons.databinding.FragmentMoonDetailsBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MoonDetailsFragment : Fragment() {

    private var binding: FragmentMoonDetailsBinding ?= null

    private val imageArgs: MoonDetailsFragmentArgs by navArgs()

    private var moonDB: DatabaseReference ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val detailsBinding = FragmentMoonDetailsBinding.inflate(inflater, container, false)
        binding = detailsBinding
        return detailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments

        if (bundle == null){
            Log.d("Confirmation", "Detail fragment didn't receive info")
            return
        }

        val detailArgs = bundle.let { MoonDetailsFragmentArgs.fromBundle(it) }

        binding?.apply {
            moonDetailsFragment = this@MoonDetailsFragment
            moonMenuX = detailArgs.moonMenuArgs
        }

        fetchedImage()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }


    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    fun addToCart(){
        findNavController().navigate(R.id.action_moonDetailsFragment_to_moonFragment)
    }

    fun backToCategory(){
        findNavController().navigate(R.id.action_moonDetailsFragment_to_moonCycleFragment)
    }

    private fun fetchedImage(){
        /*//reading data from firebase database
    FirebaseDatabase.getInstance().getReference("user")
        .addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                user.setName(dataSnapshot.child("name").getValue(String::class.java))
                user.setAddress(dataSnapshot.child("address").getValue(String::class.java))
                user.setEmail(dataSnapshot.child("email").getValue(String::class.java))
                user.setImage(dataSnapshot.child("image").getValue(String::class.java))
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })*/

        val moonRef = FirebaseDatabase.getInstance().getReference("moon_menu")
        moonDB = moonRef
        moonRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }


}