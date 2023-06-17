package com.byd.bpush.service;

import com.byd.bpush.message.EmailMessage;
import com.byd.bpush.message.wechat.agent.*;
import com.byd.bpush.message.wechat.robot.RobotMarkdownMessage;
import com.byd.bpush.message.wechat.robot.RobotNewsMessage;
import com.byd.bpush.message.wechat.robot.RobotTextMessage;

/**
 * 消息定义主类
 */
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
     * 企业微信-应用图文消息
     */
    public static AgentNewsMessage.Builder WECHAT_WORK_AGENT_NEWS() {
        return new AgentNewsMessage.Builder();
    }

    /**
     * 企业微信-应用markdown
     */
    public static AgentMarkdownMessage.Builder WECHAT_WORK_AGENT_MARKDOWN() {
        return new AgentMarkdownMessage.Builder();
    }

    /**
     * 企业微信-机器人消息文本
     */
    public static RobotTextMessage.Builder WECHAT_WORK_ROBOT_TEXT() {
        return new RobotTextMessage.Builder();
    }


    /**
     * 企业微信-机器人图文消息
     */
    public static RobotNewsMessage.Builder WECHAT_WORK_ROBOT_NEWS() {
        return new RobotNewsMessage.Builder();
    }

    /**
     * 企业微信-机器人markdown
     */
    public static RobotMarkdownMessage.Builder WECHAT_WORK_ROBOT_MARKDOWN() {
        return new RobotMarkdownMessage.Builder();
    }
}
