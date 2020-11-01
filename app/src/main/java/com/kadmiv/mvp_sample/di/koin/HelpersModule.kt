package com.kadmiv.mvp_sample.di.koin

import androidx.room.Room
import com.kadmiv.mvp_sample.BuildConfig
import com.kadmiv.mvp_sample.app.ui.main_page.AbstractMainPresenter
import com.kadmiv.mvp_sample.app.ui.main_page.IMainView
import com.kadmiv.mvp_sample.app.ui.main_page.MainPresenter
import com.kadmiv.mvp_sample.repository.android_helper.AbstractAndroidHelper
import com.kadmiv.mvp_sample.repository.android_helper.AndroidHelper
import com.kadmiv.mvp_sample.repository.database.AbstractDatabaseHelper
import com.kadmiv.mvp_sample.repository.database.DatabaseHelper
import com.kadmiv.mvp_sample.repository.preferences.AbstractPreferenceHelper
import com.kadmiv.mvp_sample.repository.preferences.PreferenceHelper
import com.kadmiv.mvp_sample.repository.database.AppDataBase
import com.kadmiv.mvp_sample.repository.network.IApi
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Kadmiv on 01.11.2020 10:52
 */

val helpersModule = module {
    factory<AbstractPreferenceHelper> { PreferenceHelper(androidApplication()) }
    factory<AbstractAndroidHelper> { AndroidHelper(androidApplication()) }
}