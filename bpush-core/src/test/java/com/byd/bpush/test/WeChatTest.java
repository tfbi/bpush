package com.byd.bpush.test;

import com.byd.push.message.wechat.agent.AgentMessage;
import com.byd.push.message.wechat.agent.AgentNewsMessage;
import com.byd.push.message.wechat.agent.AgentTextCardMessage;
import com.byd.push.message.wechat.agent.AgentTextMessage;
import com.byd.push.service.PushMessage;
import com.byd.push.service.PushService;
import com.byd.push.service.ResultCallBack;
import org.junit.Test;

public class WeChatTest {
    @Test
    public void testText() {
        AgentTextMessage msg = PushMessage.WECHAT_WORK_AGENT_TEXT().content("消息测试").toUser("5711094").build();
        PushService.sendMessage(msg);
    }

    @Test
    public void testTextCard() {
        AgentTextCardMessage msg = PushMessage.WECHAT_WORK_AGENT_TEXT_CARD()
                .title("中奖二次通知")
                .description("<div class='gray'>2023年6月16日</div> <div class='normal'>恭喜你抽中iPhone 7一台，领奖码：xxxx</div><div class='highlight'>请于2023年10月10日前联系行政同事领取</div>")
                .url("https://www.baidu.com")
                .toUser("5711094")
                .build();
        PushService.sendMessage(msg);
    }

    @Test
    public void testNews() {
        AgentNewsMessage msg = PushMessage.WECHAT_WORK_AGENT_NEWS()
                .title("端午节放假通知")
                .description("为了纪念屈原、庆祝端午节，即日起放假100天，工资每月按时发，浪就行了")
                .url("https://www.baidu.com")
                .picUrl("https://imgs.qiubiaoqing.com/qiubiaoqing/imgs/62ec7b47b9e8fBvz.gif")
                .toUser("5711094")
                .build();
        PushService.sendMessage(msg, new ResultCallBack() {
            @Override
            public void success(String result) {
                System.out.println(result);
            }

            @Override
            public void failed(String result) {
                System.out.println(result);
            }
        });
    }

    @Test
    public void testMarkDown() {
        AgentMessage msg = PushMessage
                .WECHAT_WORK_AGENT_MARKDOWN()
                .content("### 数据更新\n" +
                        "中台表数据更新，请及时关注\n" +
                        "**特别提醒** 别忘记看哦\n" +
                        "[会议地址](http://www.baidu.com)\n")
                .toUser("5711094")
                .build();
        PushService.sendMessage(msg);
    }

    @Test
    public void testRecall() {
        AgentMessage msg = PushMessage
                .WECHAT_WORK_AGENT_RECALL()
                .msgId("fcLc6UhB2absSaoEDgOVFKracDAfpUuEGu9eMUCnSEMkCj9cIBeAVwwMyRBmsRa7S_eiWek8ifx01KoWawyr5w")
                .build();
        PushService.sendMessage(msg);
    }
}
