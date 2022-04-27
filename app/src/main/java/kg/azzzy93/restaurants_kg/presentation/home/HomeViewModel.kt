package kg.azzzy93.restaurants_kg.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.azzzy93.restaurants_kg.domain.restaurant.entity.RestaurantEntity
import kg.azzzy93.restaurants_kg.domain.restaurant.usecase.GetAllRestaurantsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllRestaurantsUseCase: GetAllRestaurantsUseCase
) : ViewModel() {

    private val _restaurants = MutableStateFlow<List<RestaurantEntity>>(mutableListOf())
    val restaurants = _restaurants.asStateFlow()

    init {
        getAllRestaurants()
    }

    private fun getAllRestaurants() {
        viewModelScope.launch {
            getAllRestaurantsUseCase.execute()
                .collect {
                    _restaurants.value = it
                }
        }
    }

}