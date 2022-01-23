package com.jcardenas.superheros.view

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jcardenas.superheros.HeroApplication
import com.jcardenas.superheros.R
import com.jcardenas.superheros.databinding.FragmentHeroListBinding
import com.jcardenas.superheros.domain.entities.Hero
import com.jcardenas.superheros.helpers.Constants
import com.jcardenas.superheros.helpers.GenericAdapter
import com.jcardenas.superheros.helpers.PaginationListener
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

        setListeners()
        setObservers()
    }

    private fun setObservers(){
        viewModel.remoteHeros.observe(this, Observer {
            heroesAdapter.addItems(it)
        })
        viewModel.getHeroes()
    }

    private fun setListeners(){
        val layoutManager = binding.rvHeroes.layoutManager as LinearLayoutManager
        binding.rvHeroes.addOnScrollListener(object: PaginationListener(layoutManager) {
            override fun loadMoreItems() {
                viewModel.getHeroes()
            }

            override fun isLastPage(): Boolean = heroesAdapter.getItems().size >= Constants.MAX_CHARACTER_ID
            override fun isLoading(): Boolean = viewModel.isLoading.value == true

        })

        heroesAdapter.setOnListItemViewClickListener(object: GenericAdapter.OnListItemViewClickListener {
            override fun onClick(view: View, position: Int) {
                heroesAdapter.getItem(position)?.let { hero ->
                    val args = bundleOf(HeroDetailFragment.HERO_ID to hero.id)
                    findNavController().navigate(R.id.action_heroListFragment_to_heroDetailFragment, args)
                }
            }

        })
    }
}