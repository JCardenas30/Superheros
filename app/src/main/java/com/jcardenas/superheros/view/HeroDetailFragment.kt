package com.jcardenas.superheros.view

import com.jcardenas.superheros.R
import com.jcardenas.superheros.databinding.FragmentHeroDetailBinding
import com.jcardenas.superheros.viewmodel.HeroDetailViewModel

class HeroDetailFragment: BaseFragmentDataBinding<HeroDetailViewModel, FragmentHeroDetailBinding>() {

    override fun getLayout(): Int = R.layout.fragment_hero_detail
    override fun getViewModelClass(): Class<HeroDetailViewModel> = HeroDetailViewModel::class.java
    override fun bindViewToModel() { binding.viewModel = viewModel }

    override fun initComponents() {

    }
}