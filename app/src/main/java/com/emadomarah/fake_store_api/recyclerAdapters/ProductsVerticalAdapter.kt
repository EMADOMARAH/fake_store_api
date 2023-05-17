package com.emadomarah.fake_store_api.recyclerAdapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.emadomarah.domain.entity.product.ProductModel
import com.emadomarah.fake_store_api.R
import kotlinx.android.synthetic.main.full_producat_item.view.*

class ProductsVerticalAdapter() : ListAdapter<ProductModel, ProductsVerticalAdapter.ViewHolder>(
    CategoryDiffCallback()
) {


    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val itemBinding = LayoutInflater.from(parent.context)
            .inflate(R.layout.full_producat_item, parent, false)
        return ViewHolder(itemBinding)
    }

    // binds the list items to a view
     override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    holder.bind(getItem(position))

    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        fun bind(productModel: ProductModel){
            itemView.product_name_tv.text = productModel.title
            itemView.product_price_tv.text = "Price : ${productModel?.price} $"
            Glide.with(itemView.rootView.context).load(productModel.image).into(itemView.product_iv)
        }

    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<ProductModel>() {
        override fun areItemsTheSame(
            oldItem: ProductModel,
            newItem: ProductModel
        ): Boolean {
            return oldItem.id== newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProductModel,
            newItem: ProductModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}