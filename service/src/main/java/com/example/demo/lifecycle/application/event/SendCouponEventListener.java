package com.example.demo.lifecycle.application.event;

import com.example.demo.infrastructure.util.JSONUtil;
import com.example.demo.lifecycle.domain.service.LifeCycleDomainService;
import com.example.demo.lifecycle.infrastructure.dto.SendCouponEventDTO;
import org.springframework.stereotype.Component;

/**
 * @author baodi1
 * @description: TODO
 * @date 2021/7/21 6:37 下午
 */
@Component
public class SendCouponEventListener {//实现kafka接口

    private final LifeCycleDomainService lifeCycleDomainService;

    public SendCouponEventListener(LifeCycleDomainService lifeCycleDomainService) {
        this.lifeCycleDomainService = lifeCycleDomainService;
    }


    //模拟kafka接收消息接口
    public void recvMessage(String message) {
        if (message == null || message.trim().equals("")) {
            return;
        }
        SendCouponEventDTO event = JSONUtil.parseObject(message, SendCouponEventDTO.class);
        lifeCycleDomainService.sendCoupon(event);
    }

}
