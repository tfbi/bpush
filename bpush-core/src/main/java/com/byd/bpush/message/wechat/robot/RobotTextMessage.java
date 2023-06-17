package com.byd.bpush.message.wechat.robot;

import com.byd.bpush.message.common.BaseMessage;
import com.byd.bpush.message.common.MessageType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 企业微信机器人-文本消息
 */
public class RobotTextMessage extends BaseMessage {

    /**
     * 文本内容
     */
    private final String content;
    /**
     * 提醒人 @all表示所有人
     */
    private final List<String> mentionedList;

    private RobotTextMessage(Builder builder) {
        content = builder.content;
        mentionedList = builder.mentionedList;
        messageType = MessageType.WECHAT_ROBOT_TEXT;
    }


    @Override
    public Map<String, Object> getCoreMap() {
        Map<String, Object> textMap = new HashMap<>();
        textMap.put("content", content);
        if (mentionedList != null && mentionedList.size() > 0) {
            textMap.put("mentioned_list", mentionedList);
        }
        return textMap;
    }

    public static final class Builder {
        private String content;
        private List<String> mentionedList;

        public Builder() {
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public Builder mentionedList(List<String> val) {
            mentionedList = val;
            return this;
        }

        public RobotTextMessage build() {
            return new RobotTextMessage(this);
        }
    }
}
