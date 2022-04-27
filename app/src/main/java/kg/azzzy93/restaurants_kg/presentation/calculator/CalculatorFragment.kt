package kg.azzzy93.restaurants_kg.presentation.calculator

import kg.azzzy93.restaurants_kg.core.BaseFragment
import kg.azzzy93.restaurants_kg.databinding.FragmentCalculatorBinding

class CalculatorFragment : BaseFragment<FragmentCalculatorBinding>() {

    override fun initBinding(): FragmentCalculatorBinding {
        return FragmentCalculatorBinding.inflate(layoutInflater)
    }
}