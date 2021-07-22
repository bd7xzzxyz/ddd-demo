package com.example.demo.lifecycle.domain.repository;

import com.example.demo.lifecycle.domain.po.LifeCyclePO;

import java.util.List;

public interface LifeCycleRepository {
    /**
     * 保存
     *
     * @param lifeCyclePO
     */
    void save(LifeCyclePO lifeCyclePO);

    /**
     * 按id查询
     *
     * @param id
     * @return
     */
    LifeCyclePO findById(long id);

    /**
     * 更新状态
     *
     * @param id
     * @param status
     */
    void updateStatus(long id, int status);

    /**
     * 按类型获取生命周期
     *
     * @param type
     * @return
     */
    List<LifeCyclePO> listByType(int type);
}
