package com.kun.baselib.base

import android.content.Context
import android.os.Bundle
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.components.RxActivity
import javax.inject.Inject

/**
 * @author kun
 * @date 2017/10/20
 */
abstract class BaseActivity<T : BasePresenter<*>> : RxActivity(), BaseActivityView{
    @Inject
    protected lateinit var mPresenter: T
    protected var mActivity : BaseActivity<T>? = null
    protected var mContext : Context? = null
    abstract fun daggerInit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
        mContext = this
        daggerInit()
    }

    override fun getActivity() : BaseActivity<T> = this

    override fun getLifecycleProvider(): LifecycleProvider<ActivityEvent> {
        return this
    }

    protected fun getAppComponent() = BaseApplication.appComponent

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.destroyView()
    }
}