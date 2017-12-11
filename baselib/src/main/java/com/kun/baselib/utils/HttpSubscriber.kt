package com.kun.baselib.utils

import com.kun.baselib.net.ErrorCode
import com.kun.baselib.R
import com.kun.baselib.base.BaseResponse
import io.reactivex.subscribers.DisposableSubscriber
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * @author kun
 * @date 2017/10/19
 */
abstract class HttpSubscriber<T : BaseResponse<*>> : DisposableSubscriber<T>() {

    override fun onNext(t: T?) {
        if (200 == t?.status) {
            onSuccess(t)
        } else {
            onFail(t)
        }
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
        if (e is UnknownHostException) {
            toast(R.string.base_check_network_setting)
            noNet()
        } else if (e is SocketTimeoutException) {
            toast(R.string.base_connect_overtime)
        } else if (e is ConnectException) {
            toast(R.string.base_connect_error)
        } else {
            ToastUtil.toastLimit(R.string.base_access_fail)
        }
    }

    override fun onComplete() {

    }

    abstract fun onSuccess(response: T)

    fun onFail(t: T?) {
        if (t == null) {
            toast(R.string.base_server_error)
        } else {
            val errorMsg : String? = ErrorCode.getErrorMsg(t.status)
            toast(errorMsg ?: t.info ?: "")
        }
    }

    fun noNet() {}

    private fun toast(str: String) {
        ToastUtil.toastLimit(str)
    }
    private fun toast(strId: Int) {
        ToastUtil.toastLimit(strId)
    }
}
