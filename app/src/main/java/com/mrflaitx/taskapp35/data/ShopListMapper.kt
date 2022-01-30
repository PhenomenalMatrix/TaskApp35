package com.mrflaitx.taskapp35.data

import com.mrflaitx.taskapp35.domain.ShopItem

class ShopListMapper {

    fun mapEntityToDbModel(shopItem: ShopItem) = ShopItemDBModel(
        id = shopItem.id,
        name = shopItem.name,
        count = shopItem.count,
        enabled = shopItem.enabled
    )

    fun mapDbModelToEntity(shopItemDBModel: ShopItemDBModel) = ShopItem(
        id = shopItemDBModel.id,
        name = shopItemDBModel.name,
        count = shopItemDBModel.count,
        enabled = shopItemDBModel.enabled
    )

    fun mapListDbModelToListEntity(list: List<ShopItemDBModel>) = list.map {
        mapDbModelToEntity(it)
    }

}