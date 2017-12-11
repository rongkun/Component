package com.kun.baselib.dagger

import com.kun.baselib.base.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author kun
 * @date 2017/10/18
 */
@Module
class AppModule(private var baseApplication: BaseApplication){
    @Provides
    @Singleton
    fun providesApplication() = baseApplication
}