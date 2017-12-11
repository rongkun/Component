package com.kun.componentdemo

import com.alibaba.android.arouter.launcher.ARouter
import com.example.amodule.AModuleApplication
import com.kun.baselib.base.BaseApplication
import com.kun.bmodule.BModuleApplication

/**
 * @author 坤
 * @date 2017/12/11
 */
class ComponentApplication : BaseApplication(){
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this) // 尽可能早，推荐在Application中初始化
        //ModuleApplication初始化
        AModuleApplication().onLoad(this)
        BModuleApplication().onLoad(this)
    }
}