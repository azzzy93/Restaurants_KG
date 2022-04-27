package kg.azzzy93.restaurants_kg.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.viewbinding.ViewBinding
import kg.azzzy93.restaurants_kg.presentation.mainactivity.MainActivity

abstract class BaseFragment<VB : ViewBinding>() : Fragment() {

    protected lateinit var binding: VB
    protected abstract fun initBinding(): VB
    protected lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = initBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = (activity as MainActivity).navController

        setupUi()
        setupObservers()
        setupListeners()
    }

    open fun setupListeners() {}

    open fun setupObservers() {}

    open fun setupUi() {}
}