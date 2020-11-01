package com.kadmiv.mvp_sample.repository.database

import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import org.slf4j.Logger
import org.slf4j.LoggerFactory


abstract class AbstractDatabaseHelper {

}

/**
 * Created by Kadmiv on 01.11.2020 11:07
 */
class DatabaseHelper : AbstractDatabaseHelper(), KoinComponent {

    var LOG: Logger = LoggerFactory.getLogger(DatabaseHelper::class.java)

    val appDatabase: AppDao by inject()

}