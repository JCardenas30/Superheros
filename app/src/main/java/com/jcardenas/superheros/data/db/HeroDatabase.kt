package com.jcardenas.superheros.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jcardenas.superheros.BuildConfig
import com.jcardenas.superheros.data.entities.HeroEntity

@Database(
    entities = [
        HeroEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class HeroDatabase: RoomDatabase() {

    abstract fun heroDao(): HeroDao

    companion object{
        @Volatile
        private var INSTANCE: HeroDatabase? = null

        fun getDatabase(context: Context): HeroDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, HeroDatabase::class.java,
                    HeroDatabase::class.java.simpleName
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }

    }

}