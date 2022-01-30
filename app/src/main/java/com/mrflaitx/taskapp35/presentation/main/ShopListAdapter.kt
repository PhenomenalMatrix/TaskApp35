package com.mrflaitx.taskapp35.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mrflaitx.taskapp35.R
import com.mrflaitx.taskapp35.domain.ShopItem

//class ShopListAdapter: RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {
class ShopListAdapter: ListAdapter<ShopItem, ShopListAdapter.ShopItemViewHolder>(ShopItemDiffCallback()) {

//    var list = listOf<ShopItem>()
//    set(value) {
//        val callBack = ShopListDiffCallBack(list,value)
//        val diffResult = DiffUtil.calculateDiff(callBack)
//        diffResult.dispatchUpdatesTo(this)
//        field = value
//    }
    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        return ShopItemViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_shop_enabled,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
//        val shopItem = list[position]
        val shopItem = getItem(position)
        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()
        holder.itemView.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
    }

//    override fun getItemCount(): Int = list.size

    class ShopItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tv_name)
        val tvCount = itemView.findViewById<TextView>(R.id.tv_count)
    }
}