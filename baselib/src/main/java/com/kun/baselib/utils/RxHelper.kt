package com.kun.baselib.utils

import io.reactivex.FlowableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author kun
 * @date 2017/10/19
 */
object RxHelper {
    /**
     * 将线程调度进行封装，在io线程观察，在主线程订阅
     *
     * @param <T> 当前观察者的类型
     * @return 作为参数用于 {@link Observable#compose(ObservableTransformer)} 中
     */
    fun <T> io_main() = FlowableTransformer<T, T> { upstream ->
        upstream!!.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     *
     * @param <T> 当前观察者的类型
     * @return 作为参数用于 {@link Observable#compose(ObservableTransformer)} 中
     */
    fun <T> io_computation() = FlowableTransformer<T, T> { upstream ->
        upstream!!.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
    }
}