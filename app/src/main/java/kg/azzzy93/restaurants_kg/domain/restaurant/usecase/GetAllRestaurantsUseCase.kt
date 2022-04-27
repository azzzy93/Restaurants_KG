package kg.azzzy93.restaurants_kg.domain.restaurant.usecase

import kg.azzzy93.restaurants_kg.domain.restaurant.entity.RestaurantEntity
import kg.azzzy93.restaurants_kg.domain.restaurant.repository.GetAllRestaurantsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllRestaurantsUseCase @Inject constructor(
    private val repository: GetAllRestaurantsRepository
) {

    suspend fun execute(): Flow<List<RestaurantEntity>> {
        return repository.invoke()
    }

}