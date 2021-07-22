package com.example.demo.lifecycle.infrastructure.facade;

import com.example.demo.coupon.rpcclient.CouponInfoQueryRPC;
import com.example.demo.lifecycle.infrastructure.dto.CouponInfoDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author baodi1
 * @description: TODO
 * @date 2021/7/22 3:01 下午
 */
@Component
//防腐层
public class CouponFacade {
    private final CouponInfoQueryRPC couponInfoQueryRPC;

    public CouponFacade(CouponInfoQueryRPC couponInfoQueryRPC) {
        this.couponInfoQueryRPC = couponInfoQueryRPC;
    }

    /**
     * 券id查券服务
     * @param ids
     * @return
     */
    public List<CouponInfoDTO> queryByIds(List<Long> ids){
        //调用couponInfoQueryRPC 并通过CouponInfoAssembler转换结果
        return null;
    }
}
