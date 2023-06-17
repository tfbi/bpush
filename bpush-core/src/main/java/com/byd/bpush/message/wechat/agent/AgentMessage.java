package com.byd.bpush.message.wechat.agent;

import com.byd.bpush.message.BaseMessage;

/**
 * 应用消息父类
 **/
public abstract class AgentMessage extends BaseMessage {
    public String  toUser;

    public String getToUser() {
        return toUser;
    }

    public int enableDuplicateCheck = 0;
    public int duplicateCheckInterval = 1800;
}
