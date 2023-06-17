package com.byd.push.service;

/**
 * 消息发送回调
 */
public interface ResultCallBack {
    /**
     * 消息发送成功时触发
     * @param result json数据
     */
    public void success(String result);

    /**
     * 消息发送失败时触发
     * @param result json数据
     */
    public void failed(String result);
}
