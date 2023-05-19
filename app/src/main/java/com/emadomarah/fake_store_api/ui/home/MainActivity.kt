package com.emadomarah.fake_store_api.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.emadomarah.domain.entity.product.ProductModel
import com.emadomarah.domain.entity.product.ProductResponse
import com.emadomarah.fake_store_api.R
import com.emadomarah.fake_store_api.databinding.ActivityMainBinding
import com.emadomarah.fake_store_api.recyclerAdapters.ProductHorizontalAdapter
import com.emadomarah.fake_store_api.recyclerAdapters.ProductsVerticalAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: StoreViewModel by viewModels()

    var filter = arrayOf("all","men's clothing","jewelery","electronics","women's clothing")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this


        val adapter = ArrayAdapter(this , androidx.appcompat.R.layout.support_simple_spinner_dropdown_item , filter)
        binding.categorySpinner.adapter = adapter

        val productsVerticalAdapter = ProductsVerticalAdapter()
        val productHorizontalAdapter = ProductHorizontalAdapter()
        binding.categorySpinner.onItemSelectedListener = this



        lifecycleScope.launch {
            viewModel.getProducts()
            viewModel.products.collect {
                productsVerticalAdapter.submitList(it)
                productHorizontalAdapter.submitList(it)
                binding.verticalRecycler.adapter = productsVerticalAdapter
                binding.horizontalRecycler.adapter = productHorizontalAdapter



            }
        }










    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}