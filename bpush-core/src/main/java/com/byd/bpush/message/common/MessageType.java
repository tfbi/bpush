package com.byd.bpush.message.common;

public enum MessageType {
    EMAIL("mail"),
    WECHAT_AGENT_TEXT("text"),
    WECHAT_ROBOT_TEXT("text"),
    WECHAT_AGENT_TEXT_CARD("textcard"),
    WECHAT_AGENT_NEWS("news"),
    WECHAT_ROBOT_NEWS("news"),
    WECHAT_AGENT_RECALL("recall"),
    WECHAT_AGENT_MARKDOWN("markdown"),
    WECHAT_ROBOT_MARKDOWN("markdown"),
    WECHAT_UPLOAD_IMAGE("imageFile"),
    WECHAT_UPLOAD_FILE("file");

    private final String name;

    public String getName() {
        return name;
    }

    MessageType(String name) {
        this.name = name;
    }
}
