package com.kadmiv.mvp_sample.repository.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import io.reactivex.Maybe

@Dao
abstract class AppDao {

//    @Insert(onConflict = REPLACE)
//    abstract fun insertTask(item: TaskModel)
//
//    @Query("SELECT * FROM tasks_table ORDER BY position")
//    abstract fun getAllTasks(): Maybe<List<TaskModel>>
//
//    @Query("SELECT * FROM tasks_table WHERE id=:taskID")
//    abstract fun getTaskByID(taskID: String): Maybe<List<TaskModel>>
//
//    @Query("SELECT * FROM tasks_table WHERE end_waypoint=:wayPointID")
//    abstract fun getTaskByWayPointID(wayPointID: String): Maybe<List<TaskModel>>

}