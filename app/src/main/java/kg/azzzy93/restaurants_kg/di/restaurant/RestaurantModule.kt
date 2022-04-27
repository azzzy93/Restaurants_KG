package kg.azzzy93.restaurants_kg.di.restaurant

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kg.azzzy93.restaurants_kg.data.restaurant.local.RestaurantApi
import kg.azzzy93.restaurants_kg.data.restaurant.repository.CreateRestaurantRepositoryImpl
import kg.azzzy93.restaurants_kg.data.restaurant.repository.GetAllRestaurantsRepositoryImpl
import kg.azzzy93.restaurants_kg.data.restaurant.repository.GetRestaurantByIdRepositoryImpl
import kg.azzzy93.restaurants_kg.domain.restaurant.repository.CreateRestaurantRepository
import kg.azzzy93.restaurants_kg.domain.restaurant.repository.GetAllRestaurantsRepository
import kg.azzzy93.restaurants_kg.domain.restaurant.repository.GetRestaurantByIdRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RestaurantModule {

    @Provides
    @Singleton
    fun provideRestaurantApi(): RestaurantApi {
        return RestaurantApi()
    }

    @Provides
    @Singleton
    fun provideGetAllRestaurantsRepository(restaurantApi: RestaurantApi): GetAllRestaurantsRepository {
        return GetAllRestaurantsRepositoryImpl(restaurantApi)
    }

    @Provides
    @Singleton
    fun provideGetRestaurantByIdRepository(restaurantApi: RestaurantApi): GetRestaurantByIdRepository {
        return GetRestaurantByIdRepositoryImpl(restaurantApi)
    }

    @Provides
    @Singleton
    fun provideCreateRestaurantRepository(restaurantApi: RestaurantApi): CreateRestaurantRepository {
        return CreateRestaurantRepositoryImpl(restaurantApi)
    }

}