package com.kadmiv.mvp_sample.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kadmiv.mvp_sample.repository.database.models.TaskModel
import org.slf4j.Logger
import org.slf4j.LoggerFactory


@Database(
        entities = [
            TaskModel::class,
        ],
        version = 1
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun dao(): AppDao

    companion object {

        val MIGRATION_1_2 = object : Migration(1, 2) {
            var LOG: Logger = LoggerFactory.getLogger(Migration::class.java)

            override fun migrate(database: SupportSQLiteDatabase) {
                LOG.info("Migration ${this.startVersion} - ${this.endVersion}")

                database.execSQL(
                        "ALTER TABLE reason_table ADD COLUMN forPositions INTEGER NOT NULL DEFAULT 0")
            }
        }
    }
}
