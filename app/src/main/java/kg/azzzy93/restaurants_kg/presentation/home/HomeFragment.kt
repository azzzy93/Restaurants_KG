package kg.azzzy93.restaurants_kg.presentation.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kg.azzzy93.restaurants_kg.core.BaseFragment
import kg.azzzy93.restaurants_kg.databinding.FragmentHomeBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val adapter: HomeAdapter by lazy {
        HomeAdapter()
    }
    private val viewModel: HomeViewModel by viewModels()

    override fun initBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun setupUi() {
        binding.rvMain.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@HomeFragment.adapter
        }
    }

    override fun setupObservers() {
        viewModel.restaurants.flowWithLifecycle(lifecycle).onEach {
            adapter.submitList(it)
        }.launchIn(lifecycleScope)
    }

    override fun setupListeners() {
        binding.fab.setOnClickListener {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToCreateAdFragment())
        }
        adapter.onItemClick = {
            it.id?.let { id ->
                navController.navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(id))
            }
        }
    }

}