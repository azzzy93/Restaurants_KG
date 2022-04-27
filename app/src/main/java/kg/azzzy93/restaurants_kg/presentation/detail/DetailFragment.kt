package kg.azzzy93.restaurants_kg.presentation.detail

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import kg.azzzy93.restaurants_kg.core.BaseFragment
import kg.azzzy93.restaurants_kg.databinding.FragmentDetailBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    private val args: DetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by viewModels()
    private val adapter: DetailImageAdapter by lazy {
        DetailImageAdapter()
    }

    override fun initBinding(): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(layoutInflater)
    }

    override fun setupUi() {
        binding.viewPager.adapter = adapter
    }

    override fun setupObservers() {
        viewModel.getRestaurantById(args.id)
        viewModel.restaurant.flowWithLifecycle(lifecycle).onEach { restaurant ->
            restaurant.images?.let {
                adapter.setImageList(it)
            }
            with(binding) {
                tvName.text = restaurant.name
                val hallArea = "Площадь зала: ${restaurant.hallArea} кв/м"
                tvHallArea.text = hallArea
                val maximumCapacityOfPeople =
                    "Вместительность: ${restaurant.maximumCapacityOfPeople} чел."
                tvMaximumCapacityOfPeople.text = maximumCapacityOfPeople
                tvAddress.text = restaurant.address
                val numberPhone = "+996${restaurant.numberPhone}"
                tvNumberPhone.text = numberPhone
                tvMail.text = restaurant.mail
                tvWebSite.text = restaurant.webSite
                val averageCheckPerPerson = "Средний чек: ${restaurant.averageCheckPerPerson} сом"
                tvAverageCheckPerPerson.text = averageCheckPerPerson
                tvLocation.text = restaurant.location
            }
        }.launchIn(lifecycleScope)
    }

    override fun setupListeners() {
        binding.containerForLike.setOnClickListener {
            if (!binding.ivLikeSelected.isVisible) {
                binding.ivLikeSelected.isVisible = true
                binding.ivLike.isVisible = false
            } else {
                binding.ivLike.isVisible = true
                binding.ivLikeSelected.isVisible = false
            }
        }
    }

}