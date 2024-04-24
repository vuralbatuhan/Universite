import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.universityprojectkotlin.R
import com.example.universityprojectkotlin.databinding.RowLayoutFavouriteBinding
import com.example.universityprojectkotlin.model.University

class FavouriteUniversityAdapter(
    private val universities: List<University>
) : RecyclerView.Adapter<FavouriteUniversityAdapter.FavouriteUniversityViewHolder>() {

    inner class FavouriteUniversityViewHolder(private val binding: RowLayoutFavouriteBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imagePlus: ImageView = binding.imagePlusFavourites
        private val universityDetailsFavourites: LinearLayout = binding.universityDetailsFavourites
        private var isDetailsVisible = false

        fun bind(university: University) {
            binding.textUniversityNameFavourites.text = university.name
            binding.textUniversityPhoneFavourites.text = university.phone
            binding.textUniversityFaxFavourites.text = university.fax
            binding.textUniversityWebsiteFavourites.text = university.website
            binding.textUniversityEmailFavourites.text = university.email
            binding.textUniversityAddressFavourites.text = university.adress
            binding.textUniversityRectorFavourites.text = university.rector


            universityDetailsFavourites.visibility = View.VISIBLE

            imagePlus.setOnClickListener {
                isDetailsVisible = !isDetailsVisible
                if (isDetailsVisible) {
                    universityDetailsFavourites.visibility = View.VISIBLE
                    imagePlus.setImageResource(R.drawable.minus_icon)
                } else {
                    universityDetailsFavourites.visibility = View.GONE
                    imagePlus.setImageResource(R.drawable.plus_icon)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteUniversityViewHolder {
        val binding = RowLayoutFavouriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavouriteUniversityViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return universities.size
    }

    override fun onBindViewHolder(holder: FavouriteUniversityViewHolder, position: Int) {
        holder.bind(universities[position])
    }
}
