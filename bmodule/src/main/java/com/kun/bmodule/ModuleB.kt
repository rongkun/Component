package com.kun.bmodule

import android.util.Log
import com.kun.baselib.base.ApplicationImpl
import com.kun.baselib.base.BaseApplication

/**
 * @author 坤
 * @date 2017/12/11
 */
class ModuleB : ApplicationImpl {
    override fun onCreate(application: BaseApplication) {
        Log.i("aaa","ModuleB")
    }
}