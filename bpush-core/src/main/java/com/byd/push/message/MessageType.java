package com.byd.push.message;

public enum MessageType {
    EMAIL("mail"),
    WECHAT_AGENT_TEXT("text"),
    WECHAT_AGENT_TEXT_CARD("textcard"),
    WECHAT_AGENT_NEWS("news"),
    WECHAT_AGENT_RECALL("recall"),
    WECHAT_AGENT_MARKDOWN("markdown");

    private final String name;

    public String getName() {
        return name;
    }

    MessageType(String name) {
        this.name = name;
    }
}
