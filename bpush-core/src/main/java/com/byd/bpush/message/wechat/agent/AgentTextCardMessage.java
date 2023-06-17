package com.byd.bpush.message.wechat.agent;

import com.byd.bpush.message.common.MessageType;

import java.util.HashMap;
import java.util.Map;

/**
 * 应用-卡片消息
 **/
public class AgentTextCardMessage extends AgentMessage {
    /**
     * 文字标题
     */
    private final String title;

    private final String description;

    private final String url;


    private AgentTextCardMessage(Builder builder) {
        title = builder.title;
        description = builder.description;
        url = builder.url;
        toUser = builder.toUser;
        messageType = MessageType.WECHAT_AGENT_TEXT_CARD;
    }

    @Override
    public Map<String, Object> getCoreMap() {
        Map<String, Object> cardMap = new HashMap<>();
        cardMap.put("title", title);
        cardMap.put("description", description);
        cardMap.put("url", url);
        return cardMap;
    }


    public static final class Builder {
        private String title;
        private String description;
        private String url;
        private String toUser;

        public Builder() {
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder url(String val) {
            url = val;
            return this;
        }

        public Builder toUser(String val) {
            toUser = val;
            return this;
        }

        public AgentTextCardMessage build() {
            return new AgentTextCardMessage(this);
        }
    }
}
