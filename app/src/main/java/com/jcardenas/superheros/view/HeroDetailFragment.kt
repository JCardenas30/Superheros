package com.jcardenas.superheros.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.jcardenas.superheros.R
import com.jcardenas.superheros.databinding.FragmentHeroDetailBinding
import com.jcardenas.superheros.viewmodel.HeroDetailViewModel

class HeroDetailFragment: BaseFragmentDataBinding<HeroDetailViewModel, FragmentHeroDetailBinding>() {

    override fun getLayout(): Int = R.layout.fragment_hero_detail
    override fun getViewModelClass(): Class<HeroDetailViewModel> = HeroDetailViewModel::class.java
    override fun bindViewToModel() { binding.viewModel = viewModel }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)

        view.findViewById<Toolbar>(R.id.toolbar)
            .setupWithNavController(navController, appBarConfiguration)

    }

    override fun initComponents() {
        viewModel.setLocalHeroUseCase(heroApplication.getLocalHeroUseCase)
        viewModel.heroId.value = arguments?.getInt(HERO_ID)

        setObservers()
        viewModel.getHeroById()
    }

    private fun setObservers(){
        viewModel.heroLiveData.observe(this, Observer {
            binding.collapsingToolbar.title = it.name
        })
    }

    companion object {
        const val HERO_ID = "HERO_ID"
    }
}