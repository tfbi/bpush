package com.byd.bpush.message.wechat.robot;

import com.byd.bpush.message.common.BaseMessage;
import com.byd.bpush.message.common.MessageType;

import java.util.HashMap;
import java.util.Map;

/**
 * 企业微信机器人-markdown
 **/
public class RobotMarkdownMessage extends BaseMessage {
    /**
     * markdown文本
     */
    private final String content;

    private RobotMarkdownMessage(Builder builder) {
        content = builder.content;
        messageType = MessageType.WECHAT_ROBOT_MARKDOWN;
    }

    @Override
    public Map<String, Object> getCoreMap() {
        Map<String, Object> markdownMap = new HashMap<>();
        markdownMap.put("content", content);
        return markdownMap;
    }

    public static final class Builder {

        private String content;
        public Builder() {
        }

        public Builder content(String val) {
            content = val;
            return this;
        }
        public RobotMarkdownMessage build() {
            return new RobotMarkdownMessage(this);
        }
    }
}
