package com.emadomarah.fake_store_api.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.emadomarah.domain.entity.product.ProductModel
import com.emadomarah.fake_store_api.R
import com.emadomarah.fake_store_api.databinding.ActivityProductDetailsBinding
import com.emadomarah.fake_store_api.utils.Shared.model



class ProductDetailsActivity() : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_details)
        binding.lifecycleOwner = this

        Glide.with(this).load(model.image).into(binding.imageView)
        binding.textView.text = model.title
        binding.textView2.text = "Price : ${model.price.toString()} $"
        binding.textView3.text = model.description
    }
}