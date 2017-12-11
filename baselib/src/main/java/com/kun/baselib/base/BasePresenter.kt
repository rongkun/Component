package com.kun.baselib.base

/**
 * @author 坤
 * @date 2017/12/6
 */
open class BasePresenter<V : BaseActivityView>{
    protected var mView : V? = null

    fun attachView(mView: V) {
        this.mView = mView
    }

    fun destroyView() {
        mView = null
    }
}