package com.kadmiv.mvp_sample.di.koin

import com.kadmiv.mvp_sample.BuildConfig
import com.kadmiv.mvp_sample.repository.database.AbstractDatabaseHelper
import com.kadmiv.mvp_sample.repository.database.DatabaseHelper
import com.kadmiv.mvp_sample.repository.network.AbstractNetworkHelper
import com.kadmiv.mvp_sample.repository.network.IApi
import com.kadmiv.mvp_sample.repository.network.NetworkHelper
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Kadmiv on 01.11.2020 12:00
 */

private val TIME_OUT = 120L

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideApi(get()) }
    single { provideRetrofit(get()) }
    factory<AbstractNetworkHelper> { NetworkHelper() }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .client(okHttpClient)
        .addConverterFactory(JacksonConverterFactory.create())
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    val clientBuilder = OkHttpClient.Builder()

    clientBuilder
        .connectTimeout(TimeUnit.SECONDS.toMillis(TIME_OUT), TimeUnit.SECONDS)
        .writeTimeout(TimeUnit.SECONDS.toMillis(TIME_OUT), TimeUnit.SECONDS)
        .readTimeout(TimeUnit.SECONDS.toMillis(TIME_OUT), TimeUnit.SECONDS)

    val client = clientBuilder.build()
    return client
}

fun provideApi(retrofit: Retrofit): IApi {
    var restApi = retrofit.create(IApi::class.java)
    return restApi!!
}