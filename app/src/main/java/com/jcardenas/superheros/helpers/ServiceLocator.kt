package com.jcardenas.superheros.helpers

import android.content.Context
import com.jcardenas.superheros.BuildConfig
import com.jcardenas.superheros.data.api.HeroModule
import com.jcardenas.superheros.data.db.HeroDatabase
import com.jcardenas.superheros.data.mappers.HeroApiResponseMapper
import com.jcardenas.superheros.data.mappers.HeroEntityMapper
import com.jcardenas.superheros.data.repositories.*
import kotlinx.coroutines.Dispatchers

object ServiceLocator {
    private var database: HeroDatabase? = null
    private val baseUrl = "${BuildConfig.BASE_URL}${BuildConfig.ACCESS_TOKEN}"
    private val heroModule: HeroModule by lazy {
        HeroModule()
    }

    private val heroEntityMapper by lazy {
        HeroEntityMapper()
    }

    @Volatile
    var heroRepository: HeroRepositoryImp? = null

    fun provideHeroRepository(context: Context): HeroRepositoryImp{
        synchronized(this){
            return heroRepository ?: createHeroRepository(context)
        }
    }

    private fun createHeroRepository(context: Context): HeroRepositoryImp{
        val repo = HeroRepositoryImp(
            createHeroLocalDataSource(context),
            HeroRemoteDataSourceImp(
                heroModule.createHeroApi(baseUrl),
                HeroApiResponseMapper()
            )
        )
        heroRepository = repo
        return repo
    }

    private fun createHeroLocalDataSource(context: Context): HeroLocalDataSource{
        val database = database ?: createDatabase(context)
        return HeroLocalDataSourceImp(
            database.heroDao(),
            Dispatchers.IO,
            heroEntityMapper
        )
    }

    private fun createDatabase(context: Context): HeroDatabase{
        val result = HeroDatabase.getDatabase(context)
        database = result
        return result
    }
}