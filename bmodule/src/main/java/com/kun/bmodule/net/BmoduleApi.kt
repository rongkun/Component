package com.kun.basekotlin.net

import com.kun.baselib.base.BaseResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author kun
 * @date 2017/10/24
 */
interface BmoduleApi {
    @GET("open/api/weather/json.shtml?")
    fun getWeather(@Query("city") city: String): Flowable<BaseResponse<String>>
}