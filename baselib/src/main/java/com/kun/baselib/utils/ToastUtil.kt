package com.kun.baselib.utils

import android.content.Context
import android.widget.Toast
import com.kun.baselib.base.BaseApplication

/**
 * @author kun
 * @date 2017/10/19
 */
object ToastUtil{
    private var lastClickTime: Long = 0
    val MIN_CLICK_DELAY_TIME = 3000

    fun toastLong(ct: Context, msg: String) {
        Toast.makeText(ct, msg, Toast.LENGTH_LONG).show()
    }

    fun toastShort(ct: Context, msg: String) {
        Toast.makeText(ct, msg, Toast.LENGTH_SHORT).show()
    }

    fun toastLong(ct: Context, StringId: Int) {
        Toast.makeText(ct, StringId, Toast.LENGTH_LONG).show()
    }

    fun toastShort(ct: Context, StringId: Int) {
        Toast.makeText(ct, StringId, Toast.LENGTH_SHORT).show()
    }

    fun toastLimit(msg: String) {
        toastLimit(BaseApplication.instance.baseContext, msg)
    }
    fun toastLimit(strId: Int) {
        toastLimit(BaseApplication.instance.baseContext, strId)
    }

    fun toastLimit(ct: Context, StringId: Int) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime
            Toast.makeText(ct, StringId, Toast.LENGTH_SHORT).show()
        }
    }

    fun toastLimit(ct: Context, msg: String) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime
            Toast.makeText(ct, msg, Toast.LENGTH_SHORT).show()
        }
    }

    fun toastShort(msg: String) {
        Toast.makeText(BaseApplication.instance.baseContext, msg, Toast.LENGTH_SHORT).show()
    }

    fun toastShort(StringId: Int) {
        Toast.makeText(BaseApplication.instance.baseContext, StringId, Toast.LENGTH_SHORT).show()
    }

    /**
     *
     * @param ct 上下文
     * @param time 间隔时间 单位ms
     * @param StringId Stringid
     */
    fun toastLimit(ct: Context, time: Int, StringId: Int) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime > time) {
            lastClickTime = currentTime
            Toast.makeText(ct, StringId, Toast.LENGTH_SHORT).show()
        }
    }

    /**
     *
     * @param ct 上下文
     * @param time 间隔时间 单位ms
     * @param msg String
     */
    fun toastLimit(ct: Context, time: Int, msg: String) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime > time) {
            lastClickTime = currentTime
            Toast.makeText(ct, msg, Toast.LENGTH_SHORT).show()
        }
    }
}