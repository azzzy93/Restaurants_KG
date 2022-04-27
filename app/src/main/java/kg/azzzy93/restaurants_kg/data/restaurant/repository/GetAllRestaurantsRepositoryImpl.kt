package kg.azzzy93.restaurants_kg.data.restaurant.repository

import kg.azzzy93.restaurants_kg.data.restaurant.local.RestaurantApi
import kg.azzzy93.restaurants_kg.domain.restaurant.entity.RestaurantEntity
import kg.azzzy93.restaurants_kg.domain.restaurant.repository.GetAllRestaurantsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllRestaurantsRepositoryImpl @Inject constructor(
    private val restaurantApi: RestaurantApi
) : GetAllRestaurantsRepository {

    override suspend fun invoke(): Flow<List<RestaurantEntity>> {
        return flow {
            emit(restaurantApi.getAllRestaurants())
        }
    }
}