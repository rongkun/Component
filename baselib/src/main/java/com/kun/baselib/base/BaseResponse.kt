package com.kun.baselib.base

/**
 * @author kun
 * @date 2017/10/19
 */
data class BaseResponse<T> constructor(var status : Int){
    var info : String? = null
    var data : T? = null
}