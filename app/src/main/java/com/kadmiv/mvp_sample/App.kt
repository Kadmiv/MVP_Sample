package com.kadmiv.mvp_sample

import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.kadmiv.mvp_sample.di.koin.helpersModule
import com.kadmiv.mvp_sample.di.koin.networkModule
import com.kadmiv.mvp_sample.di.koin.presenterModule
import com.kadmiv.mvp_sample.di.koin.roomModule
import org.koin.android.ext.android.startKoin
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created by Kadmiv on 01.11.2020 10:36
 */
class App : MultiDexApplication() {
    var LOG: Logger = LoggerFactory.getLogger(App::class.java)

    override fun onCreate() {
        MultiDex.install(applicationContext)
        super.onCreate()
        LOG.info("")

        // получить список всех модулей
        val moduleList = listOf(presenterModule, roomModule, networkModule, helpersModule)
        // запустить koin со списком модулей
        startKoin(this, moduleList)

    }
}