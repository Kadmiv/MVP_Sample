package com.kadmiv.mvp_sample.app.ui.mvp_base

/**
 * Created by Kadmiv on 01.11.2020 11:15
 */
internal open interface IBasePresenter<IView> {
    fun onStart() {}
    fun onPause() {}
    fun onRestart() {}
    fun onStop() {}
    fun onSaveInstanceState() {}
    fun onDestroy() {}

    /**
     * Binds presenter with a view when resumed. The Presenter will perform initialization here.
     *
     * @param view the view associated with this presenter
     */
    fun onAttach(view: IView)

    /**
     * Drops the reference to the view when destroyed
     */
    fun onDetach()
}