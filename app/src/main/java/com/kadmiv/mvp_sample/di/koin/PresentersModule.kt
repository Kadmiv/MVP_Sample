package com.kadmiv.mvp_sample.di.koin

import com.kadmiv.mvp_sample.app.ui.main_page.AbstractMainPresenter
import com.kadmiv.mvp_sample.app.ui.main_page.IMainView
import com.kadmiv.mvp_sample.app.ui.main_page.MainPresenter
import org.koin.dsl.module.module

/**
 * Created by Kadmiv on 01.11.2020 12:03
 */
val presenterModule = module {

    single<AbstractMainPresenter<IMainView>> { MainPresenter() }
}