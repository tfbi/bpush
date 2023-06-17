package com.byd.bpush.test;

import cn.hutool.extra.mail.MailUtil;
import com.byd.push.message.EmailMessage;
import com.byd.push.service.PushMessage;
import com.byd.push.service.PushService;
import com.byd.push.utils.MailTemplateUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MailTest {
    public static void main(String[] args) {
        EmailMessage message = PushMessage.EMAIL().isHtml(true).title("测试").content("1234").receivers(Collections.singletonList("bi.tengfei1@byd.com")).build();
        PushService.sendMessage(message);
    }
}
