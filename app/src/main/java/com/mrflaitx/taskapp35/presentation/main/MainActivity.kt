package com.mrflaitx.taskapp35.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mrflaitx.taskapp35.R
import com.mrflaitx.taskapp35.databinding.ActivityMainBinding
import com.mrflaitx.taskapp35.domain.ShopItem

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding()
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapterShop: ShopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        initObserves()
        initListeners()
    }

    private fun initObserves() {
        viewModel.shopList.observe(this, { listData ->
            adapterShop.submitList(listData)
        })
    }

    private fun setupRecyclerView() {
        with(binding.mainRv){
            adapterShop = ShopListAdapter()
            adapter = adapterShop
        }
        setupSwipeListener(binding.mainRv)
    }

    private fun setupSwipeListener(rv: RecyclerView){
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item =  adapterShop.currentList[viewHolder.absoluteAdapterPosition]
                viewModel.deleteShopItem(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rv)
    }

    private fun initListeners() {
        adapterShop.onShopItemLongClickListener = {
            Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun addShopItemfun() {
        viewModel.addShopItem(ShopItem("Potato",2,false,1))
    }

}