package com.mrflaitx.taskapp35.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ShopItemDBModel::class], version = 2)
abstract class AppDataBase : RoomDatabase() {
    abstract fun shopListDao(): ShopDao
}