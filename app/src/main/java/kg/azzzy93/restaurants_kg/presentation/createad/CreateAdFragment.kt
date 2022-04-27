package kg.azzzy93.restaurants_kg.presentation.createad

import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kg.azzzy93.restaurants_kg.core.BaseFragment
import kg.azzzy93.restaurants_kg.databinding.FragmentCreateAdBinding
import kg.azzzy93.restaurants_kg.domain.restaurant.entity.RestaurantEntity

@AndroidEntryPoint
class CreateAdFragment : BaseFragment<FragmentCreateAdBinding>() {

    private val viewModel: CreateAdViewModel by viewModels()
    private val listOfCities = arrayListOf("г.Бишкек", "г.Ош")

    override fun initBinding(): FragmentCreateAdBinding {
        return FragmentCreateAdBinding.inflate(layoutInflater)
    }

    override fun setupUi() {
        setupSpinner(listOfCities, binding.spinnerLocation)
    }

    private fun setupSpinner(list: List<Any>, spinner: Spinner) {
        val adapter =
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                list
            )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    override fun setupListeners() {
        binding.btnSelectPhotos.setOnClickListener {

        }
        binding.btnSave.setOnClickListener {
            with(binding) {
                val name = etEnterName.text.toString()
                val hallArea = etEnterHallArea.text.toString()
                val maximumCapacityOfPeople = etEnterMaximumCapacityOfPeople.text.toString()
                val address = etEnterAddress.text.toString()
                val phoneNumber = etEnterPhoneNumber.text.toString()
                val mail = etEnterMail.text.toString()
                val webSite = etEnterWebSite.text.toString()
                val averageCheckPerPerson = etEnterAverageCheckPerPerson.text.toString()
                val location = spinnerLocation.selectedItem.toString()

                if (name.isNotBlank() &&
                    hallArea.isNotBlank() &&
                    maximumCapacityOfPeople.isNotBlank() &&
                    address.isNotBlank() &&
                    phoneNumber.isNotBlank() &&
                    mail.isNotBlank() &&
                    webSite.isNotBlank() &&
                    averageCheckPerPerson.isNotBlank()
                ) {
                    viewModel.createRestaurant(
                        RestaurantEntity(
                            name = name,
                            hallArea = hallArea.toInt(),
                            maximumCapacityOfPeople = maximumCapacityOfPeople.toInt(),
                            address = address,
                            numberPhone = phoneNumber.toInt(),
                            mail = mail,
                            webSite = webSite,
                            averageCheckPerPerson = averageCheckPerPerson.toInt(),
                            location = location
                        )
                    )
                    navController.navigateUp()
                }
            }
        }
    }

}