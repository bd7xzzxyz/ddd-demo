package com.example.demo.lifecycle.domain.aggregate;


import com.example.demo.lifecycle.domain.entity.LifeCycleEntity;
import com.example.demo.lifecycle.domain.po.LifeCyclePO;
import com.example.demo.lifecycle.domain.repository.LifeCycleRepository;
import com.example.demo.lifecycle.infrastructure.dto.CouponInfoDTO;
import com.example.demo.lifecycle.infrastructure.facade.CouponFacade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author baodi1
 * @description: TODO
 * @date 2021/7/21 6:42 下午
 */
@Service
public class LifeCycleAggregate {
    private final LifeCycleRepository lifeCycleRepository;
    private final CouponFacade couponFacade;

    public LifeCycleAggregate(LifeCycleRepository lifeCycleRepository, CouponFacade couponFacade) {
        this.lifeCycleRepository = lifeCycleRepository;
        this.couponFacade = couponFacade;
    }

    /**
     * 生成引入期数据
     */
    public void generatePullNew() {
        //创建实体
        LifeCycleEntity lifeCycleEntity = LifeCycleEntity.create(LifeCycleEntity.TYPE_PULL_NEW);
        //基于实体 执行业务处理 ...
        //入库
        LifeCyclePO po = LifeCycleEntity.entityToPO(lifeCycleEntity);
        lifeCycleRepository.save(po);
    }

    /**
     * 按类型获取生命周期
     *
     * @param type
     * @return
     */
    public List<LifeCycleEntity> listByType(int type) {
        List<LifeCyclePO> lifeCyclePOS = lifeCycleRepository.listByType(type);
        return lifeCyclePOS.stream().map(lifeCyclePO -> LifeCycleEntity.poToEntity(lifeCyclePO)).collect(Collectors.toList());
    }

    /**
     * 根据生命周期id获取行为信息
     * @param id
     * @return
     */
    public List getAction(long id) {
        //一些业务处理，比如根据id查询生命周期，并查询行为
        //判断是发券还是发消息
        List<Long> couponIds = new ArrayList<>();
        List<CouponInfoDTO> couponInfoDTOS = couponFacade.queryByIds(couponIds);
        //...
        return null;
    }
}
