package com.byd.bpush.config;

import cn.hutool.setting.Setting;

public class WechatWorkRobotConfig {
    public static final String WEBHOOK;
    static {
        Setting setting = new Setting("config/agent.setting");
        WEBHOOK = setting.get("");
    }
}
