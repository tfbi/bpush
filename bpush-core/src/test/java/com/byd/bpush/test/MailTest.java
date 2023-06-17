package com.byd.bpush.test;

import com.byd.bpush.message.EmailMessage;
import com.byd.bpush.service.PushMessage;
import com.byd.bpush.service.PushService;

import java.util.Collections;

public class MailTest {
    public static void main(String[] args) {
        EmailMessage message = PushMessage.EMAIL().isHtml(true).title("测试").content("1234").receivers(Collections.singletonList("bi.tengfei1@byd.com")).build();
        PushService.sendMessage(message);
    }
}
