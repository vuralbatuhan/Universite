package com.example.universityprojectkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.universityprojectkotlin.R
import com.example.universityprojectkotlin.databinding.RowLayoutBinding
import com.example.universityprojectkotlin.model.CityData

class ExpandableRecyclerViewAdapter(
    private val cityList: List<CityData>
) : RecyclerView.Adapter<ExpandableRecyclerViewAdapter.ExpandableViewHolder>() {

    private val viewHolderList = mutableListOf<ExpandableViewHolder>()

    inner class ExpandableViewHolder(private val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        val innerRecyclerView: RecyclerView? = binding.innerRecyclerView
        val imagePlus: ImageView? = binding.imagePlusMain
        var isInnerRecyclerViewVisible = false

        init {
            viewHolderList.add(this)
        }

        fun bind(city: CityData) {
            binding.textName.text = city.province
            innerRecyclerView?.layoutManager = LinearLayoutManager(itemView.context)
            innerRecyclerView?.adapter = UniversityAdapter(city.universities)

            imagePlus?.setOnClickListener {
                isInnerRecyclerViewVisible = !isInnerRecyclerViewVisible
                innerRecyclerView?.visibility = if (isInnerRecyclerViewVisible) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
                imagePlus?.setImageResource(
                    if (isInnerRecyclerViewVisible) R.drawable.minus_icon else R.drawable.plus_icon
                )
            }

            binding.textName?.setOnClickListener {
                isInnerRecyclerViewVisible = !isInnerRecyclerViewVisible
                innerRecyclerView?.visibility = if (isInnerRecyclerViewVisible) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
                imagePlus?.setImageResource(
                    if (isInnerRecyclerViewVisible) R.drawable.minus_icon else R.drawable.plus_icon
                )
            }
        }
    }

    fun closeAllInnerRecyclerViews() {
        for (viewHolder in viewHolderList) {
            if (viewHolder.isInnerRecyclerViewVisible) {
                viewHolder.isInnerRecyclerViewVisible = false
                viewHolder.innerRecyclerView?.visibility = View.GONE
                viewHolder.imagePlus?.setImageResource(R.drawable.plus_icon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpandableViewHolder {
        val binding = RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpandableViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    override fun onBindViewHolder(holder: ExpandableViewHolder, position: Int) {
        holder.bind(cityList[position])
    }
}
