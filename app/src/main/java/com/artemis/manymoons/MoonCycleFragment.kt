package com.artemis.manymoons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.artemis.manymoons.databinding.FragmentMoonCycleBinding
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


class MoonCycleFragment : Fragment(), MoonItemClickListener {

    private var binding: FragmentMoonCycleBinding ?= null

    private lateinit var adapter: MoonListAdapter

    private var moonDB: DatabaseReference? = null

    //storage for calling the firebase storage variables
    private var storage: StorageReference ?= null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val moonCycleBinding = FragmentMoonCycleBinding.inflate(inflater, container, false)
        binding = moonCycleBinding
        return moonCycleBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        moonDB = FirebaseDatabase.getInstance().getReference("moonMenu")

        // It is a class provide by the FirebaseUI to make a
        // query in the database to fetch appropriate data
        val options: FirebaseRecyclerOptions<MoonMenuX> = FirebaseRecyclerOptions.Builder<MoonMenuX>()
            .setQuery(moonDB!!, MoonMenuX::class.java)
            .build()
        
        adapter = MoonListAdapter(options, this)

        binding?.apply {
            moonCycleFragment = this@MoonCycleFragment
            moonListAdapter = adapter
        }
    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onItemClicked(moonMenuX: MoonMenuX) {
       for (moon in 1 .. 10){
           if (moon == 1){
               val action = MoonCycleFragmentDirections.actionMoonCycleFragmentToMoonDetailsFragment(moonMenuX)
               findNavController().navigate(action)
               break
           }
       }
    }

    fun closeCategory(){
        findNavController().navigate(R.id.action_moonCycleFragment_to_moonFragment)
    }


}