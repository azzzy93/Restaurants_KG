package kg.azzzy93.restaurants_kg.domain.restaurant.usecase

import kg.azzzy93.restaurants_kg.domain.restaurant.entity.RestaurantEntity
import kg.azzzy93.restaurants_kg.domain.restaurant.repository.CreateRestaurantRepository
import javax.inject.Inject

class CreateRestaurantUseCase @Inject constructor(
    private val repository: CreateRestaurantRepository
) {

    suspend fun execute(restaurant: RestaurantEntity) {
        repository.invoke(restaurant)
    }

}