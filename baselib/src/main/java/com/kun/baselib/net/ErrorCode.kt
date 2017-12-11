package com.kun.baselib.net

import android.util.SparseArray

/**
 * @author kun
 * @date 2017/10/19
 */
object ErrorCode {
    var sErrorCode: SparseArray<String> = SparseArray()
    fun getErrorMsg(code: Int): String {
        if (sErrorCode.size() == 0) {
            synchronized(ErrorCode::class.java) {
                sErrorCode.put(0, "请求正常")
                sErrorCode.put(400, "请求参数错误，详见msg")
                sErrorCode.put(500, "处理异常，请稍后重试")
                sErrorCode.put(600, "触发了平台未定义的业务行为")
                sErrorCode.put(2000, "账号数据不存在")
                sErrorCode.put(2001, "设备数据不存在")
                sErrorCode.put(2002, "厂商数据不存在")
                sErrorCode.put(2003, "聊天群不存在")
                sErrorCode.put(4000, "该设备已被绑定")
                sErrorCode.put(4001, "该设备已在某一群组中，不能再加入其它群组")
                sErrorCode.put(4002, "该设备不在此群组中，无法对其进行删除")
                sErrorCode.put(4004, "该设备未与用户绑定，所以无法进入聊天群组")
                sErrorCode.put(4005, "该数据已在设备的联系人列表中")
                sErrorCode.put(4006, "该数据不在该设备的联系人列表中")
                sErrorCode.put(4007, "该语音提醒已被删除，不在此设备中")
                sErrorCode.put(4008, "该免打扰设置已被删除，不在此设备中")
                sErrorCode.put(5001, "发送设备指令失败")
                sErrorCode.put(5002, "发送设备指令超时")
            }
        }
        return sErrorCode.get(code)
    }
}
