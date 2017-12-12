package com.kun.baselib.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.kun.baselib.BuildConfig
import com.kun.baselib.config.ModuleConfig
import com.kun.baselib.dagger.AppComponent
import com.kun.baselib.dagger.AppModule
import com.kun.baselib.dagger.DaggerAppComponent

/**
 * @author kun
 * @date 2017/10/18
 */
open class BaseApplication : Application() {

    companion object {
        lateinit var instance : BaseApplication
            private set
        lateinit var appComponent: AppComponent

    }
    override fun onCreate() {
        super.onCreate()
        instance = this
//        if(BuildConfig.DEBUG){
//            Bugtags.start(Constants.BUGTAGS_APPKEY_BETA, this, Bugtags.BTGInvocationEventNone)
//        } else run {
//            //release
//            Bugtags.start(Constants.BUGTAGS_APPKEY_LIVE, this, Bugtags.BTGInvocationEventNone)
//        }
        initializeInjector()

        if (BuildConfig.DEBUG) {
            ARouter.openLog() // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this) // 尽可能早，推荐在Application中初始化
        modulesApplicationInit()
    }
    fun initializeInjector(){
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    private fun modulesApplicationInit() {
        for (moduleImpl in ModuleConfig.MODULESLIST) {
            try {
                val clazz = Class.forName(moduleImpl)
                val obj = clazz.newInstance()
                (obj as? ApplicationImpl)?.onCreate(this)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            }

        }
    }
}