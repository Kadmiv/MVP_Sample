package com.kadmiv.mvp_sample.app.ui.main_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kadmiv.mvp_sample.R
import com.kadmiv.mvp_sample.app.ui.mvp_base.IBaseView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.get
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created by Kadmiv on 01.11.2020
 */

interface IMainView : IBaseView {
    fun changeClickCountView(clickCount: Int)

}

class MainActivity : AppCompatActivity(), IMainView {

    var LOG: Logger = LoggerFactory.getLogger(MainActivity::class.java)

    private val mPresenter: AbstractMainPresenter<IMainView> = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        LOG.info("")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter.onAttach(this)

        additionBtn.setOnClickListener { mPresenter.onAdditionBtnClick() }
    }

    override fun onDestroy() {
        LOG.info("")
        super.onDestroy()
        mPresenter.onDetach()
    }

    override fun changeClickCountView(clickCount: Int) {
        LOG.info("")
        clickCountText.text = "$clickCount"
    }
}