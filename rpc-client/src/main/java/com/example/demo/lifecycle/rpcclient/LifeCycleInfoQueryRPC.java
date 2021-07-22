package com.example.demo.lifecycle.rpcclient;

import com.example.demo.dto.RPCResponseDTO;

/**
 * @author baodi1
 * @description: TODO
 * @date 2021/7/22 2:25 下午
 */
public interface LifeCycleInfoQueryRPC {
    /**
     * 按类型查所有生命周期
     *
     * @param type
     * @return
     */
    RPCResponseDTO listByType(int type);

    /**
     * 获取一个生命周期的行为
     *
     * @param id
     * @return
     */
    RPCResponseDTO getAction(long id);
}
