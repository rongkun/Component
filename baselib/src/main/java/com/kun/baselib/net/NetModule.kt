package com.kun.baselib.net

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.kun.baselib.base.BaseApplication
import com.kun.baselib.utils.LogUtil
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author kun
 * @date 2017/10/18
 */
@Module
class NetModule{
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit{
        return Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .baseUrl(NetParams.BASE_URL)
                .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(app : BaseApplication) : OkHttpClient{
        val cacheDir = File(app.cacheDir,"http")
        val cache = Cache(cacheDir,5 * 1024 * 1024)
        return OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(getLoggingInterceptor())
                .build()
    }

    fun getLoggingInterceptor():HttpLoggingInterceptor{
        val loggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String?) {
                LogUtil.i("retrofit:" + message)
            }
        })
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }
}