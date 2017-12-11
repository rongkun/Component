package com.kun.basekotlin.dagger

import com.kun.basekotlin.net.BmoduleApi
import com.kun.baselib.dagger.PerView
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * @author kun
 * @date 2017/10/24
 */
@Module
class BmoduleModule {
    @PerView
    @Provides
    internal fun providesNetApi(retrofit: Retrofit): BmoduleApi {
        return retrofit.create<BmoduleApi>(BmoduleApi::class.java)
    }
}