package com.kadmiv.mvp_sample.repository.database.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Моделька задания маршрута
 */

const val TASKS_TABLE = "tasks_table"

@Entity(tableName = TASKS_TABLE)
open class TaskModel  {

    @NonNull
    @PrimaryKey
    var id = ""
    @ColumnInfo(name = "task_day")
    var task_day: Long = 0
}