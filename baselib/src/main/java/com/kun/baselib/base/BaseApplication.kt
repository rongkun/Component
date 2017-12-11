package com.kun.baselib.base

import android.app.Application
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
    }
    fun initializeInjector(){
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}