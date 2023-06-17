package com.byd.push.message.wechat.agent;

import com.byd.push.message.BaseMessage;
import com.byd.push.message.MessageType;

import java.util.HashMap;
import java.util.Map;

/**
 * 应用-文本消息
 **/
public abstract class AgentMessage extends BaseMessage {
    public String  toUser;

    public String getToUser() {
        return toUser;
    }

    public int enableDuplicateCheck = 0;
    public int duplicateCheckInterval = 1800;
}
