package com.byd.push.message.wechat.agent;

import com.byd.push.message.MessageType;

import java.util.HashMap;
import java.util.Map;

/**
 * 企业微信应用-撤回消息
 **/
public class AgentRecallMessage extends AgentMessage {
    /**
     * 消息ID
     */
    private final String msgId;

    private AgentRecallMessage(Builder builder) {
        msgId = builder.msgId;
        messageType = MessageType.WECHAT_AGENT_RECALL;
    }

    @Override
    public Map<String, Object> getCoreMap() {
        Map<String, Object> recallMap = new HashMap<>();
        recallMap.put("msgid", msgId);
        return recallMap;
    }

    public String getMsgId() {
        return msgId;
    }

    public static final class Builder {

        private String msgId;

        public Builder() {
        }

        public Builder msgId(String val) {
            msgId = val;
            return this;
        }

        public AgentRecallMessage build() {
            return new AgentRecallMessage(this);
        }
    }
}
