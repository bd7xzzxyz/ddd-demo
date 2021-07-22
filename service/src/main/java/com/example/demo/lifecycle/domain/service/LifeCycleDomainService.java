package com.example.demo.lifecycle.domain.service;

import com.example.demo.infrastructure.event.publish.EventPublisher;
import com.example.demo.lifecycle.domain.entity.LifeCycleEntity;
import com.example.demo.lifecycle.domain.po.LifeCyclePO;
import com.example.demo.lifecycle.domain.repository.LifeCycleRepository;
import com.example.demo.lifecycle.infrastructure.dto.CouponEventDTO;
import com.example.demo.lifecycle.infrastructure.dto.SendCouponEventDTO;
import org.springframework.stereotype.Service;

/**
 * @author baodi1
 * @description: TODO
 * @date 2021/7/22 2:02 下午
 */
@Service
//领域服务处理跨领域的业务逻辑
public class LifeCycleDomainService {
    private final LifeCycleRepository lifeCycleRepository;
    private final EventPublisher eventPublisher;

    public LifeCycleDomainService(LifeCycleRepository lifeCycleRepository, EventPublisher eventPublisher) {
        this.lifeCycleRepository = lifeCycleRepository;
        this.eventPublisher = eventPublisher;
    }

    //@Transactional 事务
    public void sendCoupon(SendCouponEventDTO event) {
        //查询生命周期信息
        LifeCyclePO lifeCyclePO = lifeCycleRepository.findById(event.getId());
        //做业务券的业务逻辑处理
        //发券事件
        CouponEventDTO couponEventDTO = new CouponEventDTO();
        eventPublisher.publishExternal("save_coupon", couponEventDTO);
        lifeCycleRepository.updateStatus(event.getId(), LifeCycleEntity.STATUS_SEND_COUPON);
    }
}
