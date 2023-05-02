package com.artemis.manymoons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.artemis.manymoons.databinding.FragmentMoonBinding


class MoonFragment : Fragment() {


    private var binding: FragmentMoonBinding ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val moonHomeBinding = FragmentMoonBinding.inflate(inflater, container, false)
        binding = moonHomeBinding
        return moonHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            moonFragment = this@MoonFragment
        }
    }

    fun launchCycle(){
        findNavController().navigate(R.id.action_moonFragment_to_moonCycleFragment)
    }


}