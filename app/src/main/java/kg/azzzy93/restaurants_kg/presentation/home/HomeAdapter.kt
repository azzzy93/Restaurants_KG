package kg.azzzy93.restaurants_kg.presentation.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.azzzy93.restaurants_kg.databinding.ItemRestaurantBinding
import kg.azzzy93.restaurants_kg.domain.restaurant.entity.RestaurantEntity

class HomeAdapter :
    ListAdapter<RestaurantEntity, HomeAdapter.ViewHolder>(RestaurantDiffCallback()) {

    var onItemClick: ((restaurant: RestaurantEntity) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRestaurantBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
        holder.onClick(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemRestaurantBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(restaurant: RestaurantEntity) {
            restaurant.images?.get(0)?.let {
                Glide.with(binding.ivMain).load(it).into(binding.ivMain)
            }
            binding.tvName.text = restaurant.name
            val maximumCapacityOfPeople =
                "Вместительность: ${restaurant.maximumCapacityOfPeople} чел."
            binding.tvMaximumCapacityOfPeople.text = maximumCapacityOfPeople
            val averageCheckPerPerson =
                "Средний чек на человека: ${restaurant.averageCheckPerPerson} сом"
            binding.tvAverageCheckPerPerson.text = averageCheckPerPerson
        }

        fun onClick(restaurant: RestaurantEntity) {
            itemView.setOnClickListener {
                onItemClick?.invoke(restaurant)
            }
        }

    }

    class RestaurantDiffCallback : DiffUtil.ItemCallback<RestaurantEntity>() {

        override fun areItemsTheSame(oldItem: RestaurantEntity, newItem: RestaurantEntity) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: RestaurantEntity, newItem: RestaurantEntity) =
            oldItem == newItem
    }
}