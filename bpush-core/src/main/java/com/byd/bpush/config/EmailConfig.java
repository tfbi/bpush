package com.byd.bpush.config;

import cn.hutool.setting.Setting;

public class EmailConfig {
    public static final String TEMPLATE;

    static {
        Setting setting = new Setting("config/mail.setting");
        TEMPLATE = setting.get("template");
    }
}
