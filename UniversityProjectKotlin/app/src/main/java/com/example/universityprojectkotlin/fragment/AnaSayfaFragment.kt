package com.example.universityprojectkotlin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.universityprojectkotlin.R
import com.example.universityprojectkotlin.databinding.FragmentAnaSayfaBinding
import com.example.universityprojectkotlin.util.gecis

class AnaSayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnaSayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnaSayfaBinding.inflate(inflater, container, false)

        binding.button.setOnClickListener {
            Navigation.gecis(it,R.id.action_anaSayfaFragment_to_universityFragment1)
        }

        return binding.root
    }

}