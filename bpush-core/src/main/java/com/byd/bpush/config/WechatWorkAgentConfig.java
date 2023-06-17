package com.byd.bpush.config;

import cn.hutool.setting.Setting;


public class WechatWorkAgentConfig {
    /**
     * 企业ID
     */
    public static final String CORP_ID;
    /**
     * 应用的凭证秘钥
     */
    public static final String SECRET;
    /**
     * 应用ID
     */
    public static final String AGENT_ID;

    static {
        Setting setting = new Setting("config/agent.setting");
        CORP_ID = setting.get("corpId");
        SECRET = setting.get("secret");
        AGENT_ID = setting.get("agentId");
    }
}
