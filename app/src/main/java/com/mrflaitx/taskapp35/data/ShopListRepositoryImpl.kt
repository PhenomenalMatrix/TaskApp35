package com.mrflaitx.taskapp35.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.mrflaitx.taskapp35.App
import com.mrflaitx.taskapp35.domain.ShopItem
import com.mrflaitx.taskapp35.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl : ShopListRepository {

//    private val shopListLD = MutableLiveData<List<ShopItem>>()
//    private val shopList = sortedSetOf<ShopItem>({o1,o2 -> o1.id.compareTo(o2.id)})

    private var autoIncrementId = 0
    private val mapper = ShopListMapper()

//    init {
//        for (i in 0 until 100){
//            val item = ShopItem ("Name $i",i,true)
//            addShopItem(item)
//        }
//    }

    override fun addShopItem(shopItem: ShopItem) {
//        if (shopItem.id == ShopItem.UNDEFINED_ID) {
//            shopItem.id = autoIncrementId++
//        }
//        shopList.add(shopItem)
//        updateList()
//        Log.e("TAG", "addShopItem: $shopItem")
    }

    override fun deleteShopItem(shopItem: ShopItem) {
//        shopList.remove(shopItem)
//        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
//        val oldElement = getShopItem(shopItem.id)
//        shopList.remove(oldElement)
//        addShopItem(shopItem)
    }

    override fun getShopList(): LiveData<List<ShopItem>> = Transformations.map(
        App.appDataBase.shopListDao().getShopList()
    ){
        mapper.mapListDbModelToListEntity(it)
    }

//    private fun updateList(){
//        shopListLD.value = shopList.toList()
//    }

    override fun getShopItem(shopItemId: Int): ShopItem {
//        return shopList.find { shopItem ->
//            shopItem.id == shopItemId
//        } ?: throw RuntimeException("Element with id $shopItemId not found")
        val dbModel = App.appDataBase.shopListDao().getShopItem(shopItemId)
        return mapper.mapDbModelToEntity(dbModel)
    }

    //Example elvis
//    val message = getMessage() ?: "empty"
//    if (!getMessage().isEmpty){
//         message = getMessage()
//    }else {
//        message = "empty"
//    }
//     fun getMessage(): String? {
//        return null
//    }

}