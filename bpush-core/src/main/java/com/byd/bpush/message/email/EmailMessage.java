package com.byd.bpush.message.email;

import com.byd.bpush.message.common.BaseMessage;
import com.byd.bpush.message.common.MessageType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailMessage extends BaseMessage {
    /**
     * 是否以html格式显示
     */
    private boolean isHtml;
    /**
     * 接收者列表
     */
    private List<String> receivers;
    /**
     * 邮件标题
     */
    private String title;
    /**
     * 邮件正文
     */
    private String content;

    public boolean isHtml() {
        return isHtml;
    }

    public void setHtml(boolean html) {
        isHtml = html;
    }

    public List<String> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<String> receivers) {
        this.receivers = receivers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "EmailMessage{" +
                "isHtml=" + isHtml +
                ", receivers=" + receivers +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    private EmailMessage(Builder builder) {
        messageType = MessageType.EMAIL;
        isHtml = builder.isHtml;
        receivers = builder.receivers;
        title = builder.title;
        content = builder.content;
    }

    @Override
    public Map<String, Object> getCoreMap() {
        Map<String, Object> maps = new HashMap<>();
        maps.put("code", content);
        return maps;
    }


    public static final class Builder {
        private boolean isHtml;
        private List<String> receivers;
        private String title;
        private String content;

        public Builder() {
        }


        public Builder isHtml(boolean val) {
            isHtml = val;
            return this;
        }

        public Builder receivers(List<String> val) {
            receivers = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public EmailMessage build() {
            return new EmailMessage(this);
        }
    }
}
