package com.example.universityprojectkotlin.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.universityprojectkotlin.R
import com.example.universityprojectkotlin.adapter.ExpandableRecyclerViewAdapter
import com.example.universityprojectkotlin.databinding.FragmentUniversity1Binding
import com.example.universityprojectkotlin.model.CityModel
import com.example.universityprojectkotlin.service.UniversityAPI2
import com.example.universityprojectkotlin.util.gecis
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UniversityFragment2 : Fragment() {
    private lateinit var binding: FragmentUniversity1Binding
    private var expandableRecyclerViewAdapter: ExpandableRecyclerViewAdapter? = null
    private var BASE_URL = "https://storage.googleapis.com/invio-com/usg-challenge/universities-at-turkey/"
    private var cityModel: CityModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUniversity1Binding.inflate(inflater, container, false)

        binding.recyclerViewId.layoutManager = LinearLayoutManager(requireContext())

        loadData()

        binding.close.setOnClickListener {
            expandableRecyclerViewAdapter?.closeAllInnerRecyclerViews()
        }

        binding.fab.setOnClickListener {
            Navigation.gecis(it,R.id.action_universityFragment2_to_universityFragment3)
        }
        binding.imageFavourite.setOnClickListener {
            Navigation.gecis(it,R.id.action_universityFragment2_to_favouriteUniversityFragment)
        }

        return binding.root
    }

    private fun loadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(UniversityAPI2::class.java)
        val call = service.getUniversity()

        call.enqueue(object : Callback<CityModel> {
            override fun onResponse(
                call: Call<CityModel>,
                response: Response<CityModel>
            ) {
                if (response.isSuccessful) {
                    cityModel = response.body()
                    expandableRecyclerViewAdapter = ExpandableRecyclerViewAdapter(cityModel?.data ?: emptyList())
                    binding.recyclerViewId.adapter = expandableRecyclerViewAdapter
                }
            }

            override fun onFailure(call: Call<CityModel>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}
