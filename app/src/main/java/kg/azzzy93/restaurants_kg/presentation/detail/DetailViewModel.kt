package kg.azzzy93.restaurants_kg.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.azzzy93.restaurants_kg.domain.restaurant.entity.RestaurantEntity
import kg.azzzy93.restaurants_kg.domain.restaurant.usecase.GetRestaurantByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getRestaurantByIdUseCase: GetRestaurantByIdUseCase
) : ViewModel() {

    private val _restaurant = MutableStateFlow(RestaurantEntity())
    val restaurant = _restaurant.asStateFlow()

    fun getRestaurantById(id: Int) {
        viewModelScope.launch {
            getRestaurantByIdUseCase.execute(id).collect {
                _restaurant.value = it
            }
        }
    }

}