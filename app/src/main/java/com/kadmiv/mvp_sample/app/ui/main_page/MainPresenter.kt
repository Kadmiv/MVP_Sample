package com.kadmiv.mvp_sample.app.ui.main_page

import com.kadmiv.mvp_sample.app.ui.mvp_base.AbstractPresenter
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created by Kadmiv on 01.11.2020 11:18
 */

abstract class AbstractMainPresenter<IView> : AbstractPresenter<IView>() {
    abstract fun onAdditionBtnClick()

}

class MainPresenter : AbstractMainPresenter<IMainView>() {
    var LOG: Logger = LoggerFactory.getLogger(MainPresenter::class.java)

    private var clickCount = 0;

    override fun onAdditionBtnClick() {
        LOG.info("")
        mView?.changeClickCountView(clickCount++)
    }
}