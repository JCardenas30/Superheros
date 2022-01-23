package com.jcardenas.superheros.view

import androidx.lifecycle.Observer
import com.jcardenas.superheros.HeroApplication
import com.jcardenas.superheros.R
import com.jcardenas.superheros.databinding.FragmentHeroListBinding
import com.jcardenas.superheros.domain.entities.Hero
import com.jcardenas.superheros.helpers.GenericAdapter
import com.jcardenas.superheros.viewmodel.HeroListViewModel

class HeroListFragment: BaseFragmentDataBinding<HeroListViewModel, FragmentHeroListBinding>() {

    override fun getLayout(): Int = R.layout.fragment_hero_list
    override fun getViewModelClass(): Class<HeroListViewModel> = HeroListViewModel::class.java
    override fun bindViewToModel() { binding.viewModel = viewModel }

    private val heroesAdapter = GenericAdapter<Hero>(R.layout.hero_item)

    override fun initComponents() {
        viewModel.setHeroRemoteUseCase(heroApplication.getRemoteHeroUseCase)
        viewModel.setLocalHeroUseCase(heroApplication.getLocalHeroUseCase)

        binding.rvHeroes.adapter = heroesAdapter

        setObservers()
    }

    private fun setObservers(){
        viewModel.remoteHeros.observe(this, Observer {
            heroesAdapter.addItems(it)
        })
        viewModel.getHeros()
    }
}