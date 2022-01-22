package com.jcardenas.superheros.view

import com.jcardenas.superheros.R
import com.jcardenas.superheros.databinding.FragmentHeroListBinding
import com.jcardenas.superheros.viewmodel.HeroListViewModel

class HeroListFragment: BaseFragmentDataBinding<HeroListViewModel, FragmentHeroListBinding>() {

    override fun getLayout(): Int = R.layout.fragment_hero_list
    override fun getViewModelClass(): Class<HeroListViewModel> = HeroListViewModel::class.java
    override fun bindViewToModel() { binding.viewModel = viewModel }

    override fun setupUI() {

    }
}