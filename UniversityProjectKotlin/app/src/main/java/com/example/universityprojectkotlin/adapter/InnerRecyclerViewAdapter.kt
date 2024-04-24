package com.example.universityprojectkotlin.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.universityprojectkotlin.R
import com.example.universityprojectkotlin.databinding.RowLayoutInnerBinding
import com.example.universityprojectkotlin.model.University

class UniversityAdapter(
    private val universityList: List<University>
) : RecyclerView.Adapter<UniversityAdapter.UniversityViewHolder>() {

    inner class UniversityViewHolder(private val binding: RowLayoutInnerBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imageHeart: ImageView = binding.imageHeart
        private val imagePlus: ImageView = binding.imagePlus
        private val universityDetails: LinearLayout = binding.universityDetails
        private var isHeartFilled = false
        private var isDetailsVisible = false

        fun bind(university: University) {
            binding.textUniversityName.text = university.name
            binding.textUniversityPhone.text = university.phone
            binding.textUniversityFax.text = university.fax
            binding.textUniversityWebsite.text = university.website
            binding.textUniversityEmail.text = university.email
            binding.textUniversityAddress.text = university.adress
            binding.textUniversityRector.text = university.rector


            imagePlus.setOnClickListener {
                isDetailsVisible = !isDetailsVisible
                if (isDetailsVisible) {
                    universityDetails.visibility = View.VISIBLE
                    imagePlus.setImageResource(R.drawable.minus_icon)
                } else {
                    universityDetails.visibility = View.GONE
                    imagePlus.setImageResource(R.drawable.plus_icon)
                }
            }

            itemView.setOnClickListener {
                isDetailsVisible = !isDetailsVisible
                if (isDetailsVisible) {
                    universityDetails.visibility = View.VISIBLE
                    imagePlus.setImageResource(R.drawable.minus_icon)
                } else {
                    universityDetails.visibility = View.GONE
                    imagePlus.setImageResource(R.drawable.plus_icon)
                }
            }

            binding.textUniversityWebsite.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(university.website))
                itemView.context.startActivity(intent)

            }

            binding.textUniversityPhone.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${university.phone}"))
                itemView.context.startActivity(intent)
            }

            imageHeart.setOnClickListener {
                isHeartFilled = !isHeartFilled
                if (isHeartFilled) {
                    imageHeart.setImageResource(R.drawable.heart)
                } else {
                    imageHeart.setImageResource(R.drawable.empty_heart)
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        val binding = RowLayoutInnerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UniversityViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return universityList.size
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        holder.bind(universityList[position])
    }
}