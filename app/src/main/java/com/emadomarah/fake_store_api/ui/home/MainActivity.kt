package com.emadomarah.fake_store_api.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.emadomarah.fake_store_api.R
import com.emadomarah.fake_store_api.databinding.ActivityMainBinding
import com.emadomarah.fake_store_api.recyclerAdapters.ProductHorizontalAdapter
import com.emadomarah.fake_store_api.recyclerAdapters.ProductsVerticalAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: StoreViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        val spinnerCategories = resources.getStringArray(R.array.spinner)
        viewModel.getProducts()


//        val adapter = ArrayAdapter(this , androidx.appcompat.R.layout.support_simple_spinner_dropdown_item , spinnerCategories)
//        binding.categorySpinner.adapter = adapter

        val productsVerticalAdapter = ProductsVerticalAdapter()
        val productHorizontalAdapter = ProductHorizontalAdapter()
        lifecycleScope.launch {
            viewModel.products.collect {
                productsVerticalAdapter.submitList(it)
                productHorizontalAdapter.submitList(it)
                binding.verticalRecycler.adapter = productsVerticalAdapter
                binding.horizontalRecycler.adapter = productHorizontalAdapter
               // binding.verticalRecycler.adapter = productsAdapter
            }
        }








    }

}