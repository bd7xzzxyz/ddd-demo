package com.example.demo.infrastructure.event.publish;


import com.example.demo.infrastructure.dto.BasicEventDTO;

/**
 * @author baodi1
 * @description: TODO
 * @date 2021/7/21 4:05 下午
 */
public interface Publisher {

    /**
     * 发布事件
     * @param message
     * @param <T>
     */
    <T extends BasicEventDTO> void publish(T message);
}
