package com.jcardenas.superheros.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragmentDataBinding<V: ViewModel, T: ViewDataBinding>: Fragment() {
    lateinit var binding: T
    lateinit var viewModel : V

    abstract fun getLayout(): Int
    abstract fun getViewModelClass(): Class<V>
    abstract fun bindViewToModel()
    abstract fun initComponents()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayout(), container, false)
        viewModel = ViewModelProvider(this).get(getViewModelClass())
        initComponents()
        bindViewToModel()
        binding.lifecycleOwner = this
        binding.executePendingBindings()
        return binding.root
    }
}