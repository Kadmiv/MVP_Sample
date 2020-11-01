package com.kadmiv.mvp_sample.app.ui.mvp_base

/**
 * Created by Kadmiv on 01.11.2020 11:14
 */
abstract class AbstractPresenter<IView> : IBasePresenter<IView> {
    protected var mView: IView? = null

    override fun onAttach(view: IView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }

    fun isAttached(): Boolean {
        return mView != null
    }
}