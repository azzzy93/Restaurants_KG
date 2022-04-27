package kg.azzzy93.restaurants_kg.presentation.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.azzzy93.restaurants_kg.databinding.ItemImageBinding

class DetailImageAdapter : RecyclerView.Adapter<DetailImageAdapter.ViewHolder>() {

    private val imagesList = ArrayList<String>()

    fun setImageList(imagesList: List<String>) {
        this.imagesList.addAll(imagesList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(imagesList[position])
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }

    class ViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(url: String) {
            Glide.with(binding.iv).load(url).into(binding.iv)
        }

    }
}