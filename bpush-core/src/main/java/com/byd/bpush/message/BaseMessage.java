package com.byd.bpush.message;

import java.io.Serializable;
import java.util.Map;

public abstract class BaseMessage implements Serializable {
    public MessageType messageType;

    public abstract Map<String,Object> getCoreMap();

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
}
