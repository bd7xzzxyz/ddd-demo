package com.example.demo.lifecycle.domain.repository.impl;

import com.example.demo.lifecycle.domain.po.LifeCyclePO;
import com.example.demo.lifecycle.domain.repository.LifeCycleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author baodi1
 * @description: TODO
 * @date 2021/7/22 1:46 下午
 */
@Repository
public class LifeCycleRepositoryImpl implements LifeCycleRepository {
    @Override
    public void save(LifeCyclePO lifeCyclePO) {

    }

    @Override
    public LifeCyclePO findById(long id) {
        return null;
    }

    @Override
    public void updateStatus(long id, int status) {

    }

    @Override
    public List<LifeCyclePO> listByType(int type) {
        return null;
    }
}
