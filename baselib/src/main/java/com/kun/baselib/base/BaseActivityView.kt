package com.kun.baselib.base

import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.ActivityEvent

/**
 * @author kun
 * @date 2017/10/20
 */
interface BaseActivityView{
    fun getActivity() : BaseActivity<*>?
    fun getLifecycleProvider() : LifecycleProvider<ActivityEvent>
}