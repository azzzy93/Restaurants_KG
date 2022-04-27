package kg.azzzy93.restaurants_kg.domain.restaurant.repository

import kg.azzzy93.restaurants_kg.domain.restaurant.entity.RestaurantEntity
import kotlinx.coroutines.flow.Flow

interface GetAllRestaurantsRepository {

    suspend fun invoke(): Flow<List<RestaurantEntity>>

}