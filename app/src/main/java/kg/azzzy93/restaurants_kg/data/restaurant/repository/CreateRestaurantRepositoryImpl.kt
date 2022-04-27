package kg.azzzy93.restaurants_kg.data.restaurant.repository

import kg.azzzy93.restaurants_kg.data.restaurant.local.RestaurantApi
import kg.azzzy93.restaurants_kg.domain.restaurant.entity.RestaurantEntity
import kg.azzzy93.restaurants_kg.domain.restaurant.repository.CreateRestaurantRepository
import javax.inject.Inject

class CreateRestaurantRepositoryImpl @Inject constructor(
    private val restaurantApi: RestaurantApi
): CreateRestaurantRepository {

    override suspend fun invoke(restaurant: RestaurantEntity) {
        restaurantApi.createRestaurant(restaurant)
    }
}