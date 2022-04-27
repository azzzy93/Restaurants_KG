package kg.azzzy93.restaurants_kg.data.restaurant.repository

import kg.azzzy93.restaurants_kg.data.restaurant.local.RestaurantApi
import kg.azzzy93.restaurants_kg.domain.restaurant.entity.RestaurantEntity
import kg.azzzy93.restaurants_kg.domain.restaurant.repository.GetRestaurantByIdRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetRestaurantByIdRepositoryImpl @Inject constructor(
    private val restaurantApi: RestaurantApi
) : GetRestaurantByIdRepository {

    override suspend fun invoke(id: Int): Flow<RestaurantEntity> {
        return flow {
            restaurantApi.getRestaurantById(id)
        }
    }
}