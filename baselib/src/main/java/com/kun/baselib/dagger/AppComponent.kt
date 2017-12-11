package com.kun.baselib.dagger

import com.kun.baselib.net.NetModule
import com.kun.baselib.base.BaseApplication
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author kun
 * @date 2017/10/18
 */
@Singleton
@Component(modules = arrayOf(AppModule :: class,NetModule::class))
interface AppComponent{
    fun provideRetrofit() : Retrofit
    fun providesApplication() : BaseApplication
}