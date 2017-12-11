package com.example.amodule

import android.util.Log
import com.kun.baselib.base.ApplicationImpl
import com.kun.baselib.base.BaseApplication

/**
 * @author 坤
 * @date 2017/12/11
 */
class AModuleApplication : ApplicationImpl{
    override fun onLoad(application: BaseApplication) {
        Log.i("aaa","AModule")
    }

}