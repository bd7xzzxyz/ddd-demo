package com.example.demo.lifecycle.controller;

import com.example.demo.infrastructure.dto.ResponseDTO;
import com.example.demo.infrastructure.event.publish.EventPublisher;
import com.example.demo.lifecycle.infrastructure.assembler.LifeCycleQueryAssembler;
import com.example.demo.lifecycle.infrastructure.assembler.SendCouponAssembler;
import com.example.demo.lifecycle.rpcclient.LifeCycleInfoQueryRPC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baodi1
 * @description: TODO
 * @date 2021/7/21 2:26 下午
 */
@RestController
public class LifecycleController {
    private final EventPublisher eventPublisher;
    private final LifeCycleInfoQueryRPC infoQueryRPC;

    public LifecycleController(EventPublisher eventPublisher, LifeCycleInfoQueryRPC infoQueryRPC) {
        this.eventPublisher = eventPublisher;
        this.infoQueryRPC = infoQueryRPC;
    }

    @GetMapping("/list/{type}")
    //获取所有生命周期
    public ResponseDTO listByType(@PathVariable int type) {
        return LifeCycleQueryAssembler.convertListByTypeDTO(infoQueryRPC.listByType(type));
    }

    @GetMapping("/send_coupon/{id}")
    //为生命周期发券
    public ResponseDTO sendCoupon(@PathVariable long id, @RequestParam("amount") long amount) {
        //触发事件
        eventPublisher.publishExternal("send_coupon", SendCouponAssembler.buildEventDTO(id, amount));
        return null;
    }

    @GetMapping("/action/{id}")
    //获取某个生命周期的动作明细
    public ResponseDTO getAction(@PathVariable long id) {
        return LifeCycleQueryAssembler.convertGetActionDTO(infoQueryRPC.getAction(id));
    }
}
