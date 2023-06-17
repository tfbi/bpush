package com.byd.bpush.message.wechat.agent;

import com.byd.bpush.message.common.MessageType;

import java.util.HashMap;
import java.util.Map;

/**
 * 企业微信应用-markdown
 **/
public class AgentMarkdownMessage extends AgentMessage {
    /**
     * markdown文本
     */
    private final String content;

    private AgentMarkdownMessage(Builder builder) {
        content = builder.content;
        toUser = builder.toUser;
        messageType = MessageType.WECHAT_AGENT_MARKDOWN;
    }

    @Override
    public Map<String, Object> getCoreMap() {
        Map<String, Object> markdownMap = new HashMap<>();
        markdownMap.put("content", content);
        return markdownMap;
    }

    public static final class Builder {

        private String content;
        private String toUser;

        public Builder() {
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public Builder toUser(String val) {
            toUser = val;
            return this;
        }

        public AgentMarkdownMessage build() {
            return new AgentMarkdownMessage(this);
        }
    }
}
