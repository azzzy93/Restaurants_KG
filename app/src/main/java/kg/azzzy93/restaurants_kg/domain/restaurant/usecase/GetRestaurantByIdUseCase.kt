package kg.azzzy93.restaurants_kg.domain.restaurant.usecase

import kg.azzzy93.restaurants_kg.domain.restaurant.entity.RestaurantEntity
import kg.azzzy93.restaurants_kg.domain.restaurant.repository.GetRestaurantByIdRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRestaurantByIdUseCase @Inject constructor(
    private val repository: GetRestaurantByIdRepository
) {

    suspend fun execute(id: Int): Flow<RestaurantEntity> {
        return repository.invoke(id)
    }

}