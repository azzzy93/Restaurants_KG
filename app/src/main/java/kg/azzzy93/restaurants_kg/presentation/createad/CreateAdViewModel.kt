package kg.azzzy93.restaurants_kg.presentation.createad

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.azzzy93.restaurants_kg.domain.restaurant.entity.RestaurantEntity
import kg.azzzy93.restaurants_kg.domain.restaurant.usecase.CreateRestaurantUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateAdViewModel @Inject constructor(
    private val createRestaurantUseCase: CreateRestaurantUseCase
) : ViewModel() {

    fun createRestaurant(restaurant: RestaurantEntity) {
        viewModelScope.launch {
            createRestaurantUseCase.execute(restaurant)
        }
    }

}