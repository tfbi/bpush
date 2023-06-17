package com.byd.bpush.message.wechat.agent;

import com.byd.bpush.message.MessageType;

import java.util.HashMap;
import java.util.Map;

/**
 * 应用-文本消息
 **/
public class AgentTextMessage extends AgentMessage {
    /**
     * 文字内容
     */
    private final String content;


    private AgentTextMessage(Builder builder) {
        content = builder.content;
        toUser = builder.toUser;
        messageType = MessageType.WECHAT_AGENT_TEXT;
    }

    @Override
    public Map<String, Object> getCoreMap() {
        Map<String, Object> textMap = new HashMap<>();
        textMap.put("content", content);
        return textMap;
    }


    public static final class Builder {
        private String content;
        private String toUser;

        public Builder() {
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder toUser(String toUser) {
            this.toUser = toUser;
            return this;
        }

        public AgentTextMessage build() {
            return new AgentTextMessage(this);
        }
    }
}
