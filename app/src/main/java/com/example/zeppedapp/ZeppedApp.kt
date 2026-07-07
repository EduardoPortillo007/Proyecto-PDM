package com.example.zeppedapp

import android.app.Application
import androidx.room.Room
import com.example.zeppedapp.data.local.ZeppedDatabase

class ZeppedApp : Application() {

    companion object {
        lateinit var database: ZeppedDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            ZeppedDatabase::class.java,
            "zeppedapp_db"
        ).build()
    }
}