package kg.azzzy93.restaurants_kg.presentation.favorites

import kg.azzzy93.restaurants_kg.core.BaseFragment
import kg.azzzy93.restaurants_kg.databinding.FragmentFavoritesBinding

class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>() {

    override fun initBinding(): FragmentFavoritesBinding {
        return FragmentFavoritesBinding.inflate(layoutInflater)
    }
}