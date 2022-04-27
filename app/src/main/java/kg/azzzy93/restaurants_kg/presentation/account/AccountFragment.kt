package kg.azzzy93.restaurants_kg.presentation.account

import kg.azzzy93.restaurants_kg.core.BaseFragment
import kg.azzzy93.restaurants_kg.databinding.FragmentAccountBinding

class AccountFragment : BaseFragment<FragmentAccountBinding>() {

    override fun initBinding(): FragmentAccountBinding {
        return FragmentAccountBinding.inflate(layoutInflater)
    }

}