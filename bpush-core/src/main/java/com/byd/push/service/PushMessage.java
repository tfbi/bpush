package com.byd.push.service;

import com.byd.push.message.EmailMessage;
import com.byd.push.message.wechat.agent.*;

public class PushMessage {

    /**
     * 邮箱普通邮件
     */
    public static EmailMessage.Builder EMAIL() {
        return new EmailMessage.Builder();
    }

    /**
     * 企业微信-撤回应用消息
     */
    public static AgentRecallMessage.Builder WECHAT_WORK_AGENT_RECALL() {
        return new AgentRecallMessage.Builder();
    }

    /**
     * 企业微信-应用消息文本
     */
    public static AgentTextMessage.Builder WECHAT_WORK_AGENT_TEXT() {
        return new AgentTextMessage.Builder();
    }

    /**
     * 企业微信-应用卡片消息
     */
    public static AgentTextCardMessage.Builder WECHAT_WORK_AGENT_TEXT_CARD() {
        return new AgentTextCardMessage.Builder();
    }

    /**
     * 企业微信-图文消息
     */
    public static AgentNewsMessage.Builder WECHAT_WORK_AGENT_NEWS() {
        return new AgentNewsMessage.Builder();
    }

    /**
     * 企业微信-图文消息
     */
    public static AgentMarkdownMessage.Builder WECHAT_WORK_AGENT_MARKDOWN() {
        return new AgentMarkdownMessage.Builder();
    }
}
