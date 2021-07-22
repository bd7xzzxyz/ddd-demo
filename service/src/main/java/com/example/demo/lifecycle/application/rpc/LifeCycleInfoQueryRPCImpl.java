package com.example.demo.lifecycle.application.rpc;

import com.example.demo.dto.RPCResponseDTO;
import com.example.demo.lifecycle.domain.aggregate.LifeCycleAggregate;
import com.example.demo.lifecycle.domain.entity.LifeCycleEntity;
import com.example.demo.lifecycle.domain.service.LifeCycleDomainService;
import com.example.demo.lifecycle.infrastructure.assembler.LifeCycleInfoQueryAssembler;
import com.example.demo.lifecycle.rpcclient.LifeCycleInfoQueryRPC;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author baodi1
 * @description: TODO
 * @date 2021/7/22 3:02 下午
 */
@Service
public class LifeCycleInfoQueryRPCImpl implements LifeCycleInfoQueryRPC {

    private final LifeCycleAggregate lifeCycleAggregate;
    private final LifeCycleDomainService lifeCycleDomainService;

    public LifeCycleInfoQueryRPCImpl(LifeCycleAggregate lifeCycleAggregate, LifeCycleDomainService lifeCycleDomainService) {
        this.lifeCycleAggregate = lifeCycleAggregate;
        this.lifeCycleDomainService = lifeCycleDomainService;
    }

    @Override
    public RPCResponseDTO listByType(int type) {
        List<LifeCycleEntity> entityList = lifeCycleAggregate.listByType(type);
        return LifeCycleInfoQueryAssembler.buildListByTypeRpcDTO(entityList);
    }

    @Override
    public RPCResponseDTO getAction(long id) {
        lifeCycleAggregate.getAction(id);
        //LifeCycleInfoQueryAssembler 转换dto
        return null;
    }
}
