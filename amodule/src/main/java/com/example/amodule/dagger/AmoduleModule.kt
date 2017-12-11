package com.kun.basekotlin.dagger

import com.kun.basekotlin.net.AmoduleApi
import com.kun.baselib.dagger.PerView
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * @author kun
 * @date 2017/10/24
 */
@Module
class AmoduleModule {
    @PerView
    @Provides
    internal fun providesNetApi(retrofit: Retrofit): AmoduleApi {
        return retrofit.create<AmoduleApi>(AmoduleApi::class.java)
    }
}