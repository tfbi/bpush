package com.byd.bpush.service;

import cn.hutool.extra.mail.MailUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.byd.bpush.config.EmailConfig;
import com.byd.bpush.config.WechatWorkAgentConfig;
import com.byd.bpush.config.WechatWorkRobotConfig;
import com.byd.bpush.message.BaseMessage;
import com.byd.bpush.message.EmailMessage;
import com.byd.bpush.message.wechat.agent.AgentMessage;
import com.byd.bpush.utils.MailTemplateUtils;

import java.util.HashMap;
import java.util.Map;

public class PushService {
    private static final String BASE_URL = "https://qyapi.weixin.qq.com/cgi-bin";
    private static final String RECALL_URL = BASE_URL + "/message/recall?access_token=%s";
    private static final String TOKEN_URL = BASE_URL + "/gettoken" + "?corpid=%s&corpsecret=%s";
    private static final String AGENT_URL = BASE_URL + "/message/send?access_token=%s";

    public static void sendMessage(BaseMessage msg, ResultCallBack callBack) {
        String response = null;
        switch (msg.messageType) {
            case EMAIL:
                sendEmailMessage(msg);
                break;
            case WECHAT_AGENT_RECALL:
                response = sendRecallMessage(msg);
                break;
            case WECHAT_AGENT_TEXT:
            case WECHAT_AGENT_TEXT_CARD:
            case WECHAT_AGENT_NEWS:
            case WECHAT_AGENT_MARKDOWN:
                response = sendAgentMessage(msg);
                break;
            case WECHAT_ROBOT_TEXT:
            case WECHAT_ROBOT_NEWS:
            case WECHAT_ROBOT_MARKDOWN:
                response = sendRobotMessage(msg);
                break;
        }
        if (callBack != null) {
            if (response != null) {
                cn.hutool.json.JSONObject jsonObject = JSONUtil.parseObj(response);
                if (jsonObject.getInt("errcode") == 0) {
                    callBack.success(response);
                } else {
                    callBack.failed(response);
                }
            }
        }

    }


    public static void sendMessage(BaseMessage msg) {
        sendMessage(msg, null);
    }

    private static String sendEmailMessage(BaseMessage msg) {
        EmailMessage message = (EmailMessage) msg;
        if (message.isHtml()) {
            String content = MailTemplateUtils.getContent(message.getCoreMap(), EmailConfig.TEMPLATE);
            return MailUtil.send(message.getReceivers(), message.getTitle(), content, true);
        } else {
            return MailUtil.send(message.getReceivers(), message.getTitle(), message.getContent(), false);
        }
    }

    private static String sendRecallMessage(BaseMessage msg) {
        AgentMessage message = (AgentMessage) msg;
        String url = String.format(RECALL_URL, getAgentAccessToken());
        String param = JSONUtil.toJsonStr(message.getCoreMap());
        return HttpUtil.post(url, param);
    }

    private static String sendAgentMessage(BaseMessage msg) {
        AgentMessage message = (AgentMessage) msg;
        Map<String, Object> data = new HashMap<String, Object>();
        String url = String.format(AGENT_URL, getAgentAccessToken());
        data.put(WechatParams.TO_USER, message.getToUser());
        data.put(WechatParams.MSG_TYPE, message.getMessageType().getName());
        data.put(WechatParams.AGENT_ID, WechatWorkAgentConfig.AGENT_ID);
        data.put(message.getMessageType().getName(), message.getCoreMap());
        String param = JSONUtil.toJsonStr(data);
        return HttpUtil.post(url, param);
    }

    private static String sendRobotMessage(BaseMessage msg) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put(WechatParams.MSG_TYPE, msg.getMessageType().getName());
        data.put(msg.getMessageType().getName(), msg.getCoreMap());
        String param = JSONUtil.toJsonStr(data);
        return HttpUtil.post(WechatWorkRobotConfig.WEBHOOK, param);
    }


    private static String getAgentAccessToken() {
        String url = String.format(TOKEN_URL, WechatWorkAgentConfig.CORP_ID, WechatWorkAgentConfig.SECRET);
        String result = HttpUtil.get(url);
        cn.hutool.json.JSONObject jsonObject = JSONUtil.parseObj(result);
        return jsonObject.get(WechatParams.ACCESS_TOKEN).toString();
    }
}
