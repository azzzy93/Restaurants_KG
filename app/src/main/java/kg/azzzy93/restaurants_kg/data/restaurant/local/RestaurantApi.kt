package kg.azzzy93.restaurants_kg.data.restaurant.local

import kg.azzzy93.restaurants_kg.domain.restaurant.entity.RestaurantEntity

class RestaurantApi {

    private val restaurants = arrayListOf<RestaurantEntity>()

    init {
        for (i in 0..5) {
            restaurants.add(
                RestaurantEntity(
                    id = i,
                    name = "Saltanat Palace",
                    hallArea = 400,
                    maximumCapacityOfPeople = 1000,
                    address = "г.Бишкек, ул.Шопокова, 58",
                    numberPhone = 700929099,
                    mail = "saltanat@gmail.com",
                    webSite = "https://saltanatpalacekg.business.site",
                    images = listOf(
                        "https://lh3.googleusercontent.com/p/AF1QipMtgjmEVFB00_JFWrxl-pGKqrfKZ9NOanCvhoqW=w1080-h608-p-no-v0",
                        "https://d34gu9h9mtzjxz.cloudfront.net/lib/profiles/8310/slide1/76aa2b190856a8aac6612db124cdb6f18a809aa5_x3.jpg",
                        "https://restoran-inform.ru/wp-content/uploads/2020/12/common-14833.jpeg"
                    ),
                    averageCheckPerPerson = 1200,
                    location = "г.Бишкек"
                )
            )
        }
    }

    fun getAllRestaurants(): List<RestaurantEntity> {
        return restaurants
    }

    fun getRestaurantById(id: Int): RestaurantEntity {
        return restaurants[id]
    }

    fun createRestaurant(restaurant: RestaurantEntity) {
        restaurants.add(restaurant)
    }

}