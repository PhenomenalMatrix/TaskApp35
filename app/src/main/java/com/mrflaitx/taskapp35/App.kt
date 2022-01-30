package com.mrflaitx.taskapp35

import android.app.Application
import androidx.room.Room
import com.mrflaitx.taskapp35.data.AppDataBase

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        appDataBase = Room.databaseBuilder(this,AppDataBase::class.java,"dataBase")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    companion object{
        lateinit var appDataBase: AppDataBase
    }
}