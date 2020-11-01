package com.kadmiv.mvp_sample.di.koin

import androidx.room.Room
import com.kadmiv.mvp_sample.repository.database.AbstractDatabaseHelper
import com.kadmiv.mvp_sample.repository.database.AppDataBase
import com.kadmiv.mvp_sample.repository.database.DatabaseHelper
import org.koin.dsl.module.module

/**
 * Created by Kadmiv on 01.11.2020 12:01
 */
const val APP_DB_NAME = "app.db"

val roomModule = module {

    single {
        val builder = Room.databaseBuilder(
            get(),
            AppDataBase::class.java,
            APP_DB_NAME
        )
        builder.fallbackToDestructiveMigration() // For migration delete all data
//        builder.addMigrations(AppDataBase.MIGRATION_10_11)
        builder.build()
    }

    single { get<AppDataBase>().dao() }

    factory<AbstractDatabaseHelper> { DatabaseHelper() }
}