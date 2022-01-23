package com.jcardenas.superheros.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jcardenas.superheros.data.entities.HeroEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HeroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeros(heros: List<HeroEntity>)

    @Query("SELECT * FROM hero h WHERE h.id = :heroId")
    fun getHero(heroId: Int): Flow<HeroEntity>

}