package com.kun.baselib.utils

import android.util.Log
import com.kun.baselib.BuildConfig

/**
 * @author kun
 * @date 2017/10/18
 */
object LogUtil{
    val TAG = "TAG"
    fun e(text : String){
        if (BuildConfig.DEBUG){
            Log.e(TAG,text)
        }
    }
    fun i(text : String){
        if (BuildConfig.DEBUG){
            Log.i(TAG,text)
        }
    }
    fun d(text : String){
        if (BuildConfig.DEBUG){
            Log.d(TAG,text)
        }
    }
    fun w(text : String){
        if (BuildConfig.DEBUG){
            Log.w(TAG,text)
        }
    }
    fun v(text : String){
        if (BuildConfig.DEBUG){
            Log.v(TAG,text)
        }
    }

    fun e(tag : String,text : String){
        if (BuildConfig.DEBUG){
            Log.e(tag,text)
        }
    }
    fun i(tag : String,text : String){
        if (BuildConfig.DEBUG){
            Log.i(tag,text)
        }
    }
    fun d(tag : String,text : String){
        if (BuildConfig.DEBUG){
            Log.d(tag,text)
        }
    }
    fun w(tag : String,text : String){
        if (BuildConfig.DEBUG){
            Log.w(tag,text)
        }
    }
    fun v(tag : String,text : String){
        if (BuildConfig.DEBUG){
            Log.v(tag,text)
        }
    }
}