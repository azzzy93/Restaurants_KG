package kg.azzzy93.restaurants_kg.domain.restaurant.repository

import kg.azzzy93.restaurants_kg.domain.restaurant.entity.RestaurantEntity

interface CreateRestaurantRepository {

    suspend fun invoke(restaurant: RestaurantEntity)

}