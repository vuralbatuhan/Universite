package com.example.universityprojectkotlin.fragment

import FavouriteUniversityAdapter
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.universityprojectkotlin.databinding.FragmentFavouriteUniversityBinding
import com.example.universityprojectkotlin.model.University
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class FavouriteUniversityFragment : Fragment() {
    private lateinit var binding: FragmentFavouriteUniversityBinding
    private lateinit var favouriteUniversityAdapter: FavouriteUniversityAdapter
    private lateinit var sharedPreferences: SharedPreferences
    private var favouriteUniversities: MutableList<University> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteUniversityBinding.inflate(inflater, container, false)

        sharedPreferences = requireContext().getSharedPreferences("favourites", Context.MODE_PRIVATE)

        setupRecyclerView()
        loadFavouriteUniversities()

        return binding.root
    }

    private fun setupRecyclerView() {
        favouriteUniversityAdapter = FavouriteUniversityAdapter(favouriteUniversities)
        binding.recyclerViewId.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewId.adapter = favouriteUniversityAdapter
    }

    private fun loadFavouriteUniversities() {
        val json = sharedPreferences.getString("favourite_universities", "")
        favouriteUniversities = if (json.isNullOrEmpty()) {
            mutableListOf()
        } else {
            Gson().fromJson(json, object : TypeToken<List<University>>() {}.type)
        }

        favouriteUniversityAdapter.notifyDataSetChanged()
    }
}
