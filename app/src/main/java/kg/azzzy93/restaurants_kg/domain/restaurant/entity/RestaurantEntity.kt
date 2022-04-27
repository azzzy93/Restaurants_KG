package kg.azzzy93.restaurants_kg.domain.restaurant.entity

data class RestaurantEntity(
    val id: Int? = null,
    val isFavorites: Boolean? = null,
    val name: String? = null,
    val hallArea: Int? = null,
    val maximumCapacityOfPeople: Int? = null,
    val address: String? = null,
    val numberPhone: Int? = null,
    val mail: String? = null,
    val webSite: String? = null,
    val images: List<String>? = null,
    val averageCheckPerPerson: Int? = null,
    val location: String? = null
)
