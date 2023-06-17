package com.byd.bpush.message.wechat.robot;

import com.byd.bpush.message.common.BaseMessage;
import com.byd.bpush.message.common.MessageType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 企业微信机器人-图文消息
 **/
public class RobotNewsMessage extends BaseMessage {
    /**
     * 文字标题
     */
    private final String title;
    /**
     * 文本描述
     */
    private final String description;
    /**
     * 点击后跳转地址
     */
    private final String url;
    /**
     * 图片的url地址
     */
    private final String picUrl;

    private RobotNewsMessage(Builder builder) {
        title = builder.title;
        description = builder.description;
        url = builder.url;
        picUrl = builder.picUrl;
        messageType = MessageType.WECHAT_ROBOT_NEWS;
    }

    @Override
    public Map<String, Object> getCoreMap() {
        Map<String, Object> newMap = new HashMap<>();
        Map<String, Object> articlesMap = new HashMap<>();
        articlesMap.put("title", title);
        articlesMap.put("description", description);
        articlesMap.put("url", url);
        articlesMap.put("picurl", picUrl);
        newMap.put("articles", Collections.singletonList(articlesMap));
        return newMap;
    }


    public static final class Builder {
        private String picUrl;
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

        public Builder picUrl(String val) {
            picUrl = val;
            return this;
        }

        public Builder toUser(String val) {
            toUser = val;
            return this;
        }

        public RobotNewsMessage build() {
            return new RobotNewsMessage(this);
        }
    }
}
