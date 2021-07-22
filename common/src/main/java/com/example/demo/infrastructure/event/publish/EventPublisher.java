package com.example.demo.infrastructure.event.publish;

import com.example.demo.infrastructure.dto.BasicEventDTO;
import com.example.demo.infrastructure.util.IDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author baodi1
 * @description: TODO
 * @date 2021/7/21 4:13 下午
 */
@Component
@Slf4j
public class EventPublisher {
    private final Publisher internalPublisher;
    private final Publisher externalPublisher;

    public EventPublisher(@Qualifier("eventBusPublisher") Publisher internalPublisher,
                          @Qualifier("kafkaPublisher") Publisher externalPublisher) {
        this.internalPublisher = internalPublisher;
        this.externalPublisher = externalPublisher;
    }

    /**
     * 发布领域内事件（EventBus通道）
     *
     * @param event
     * @param <T>
     */
    public <T extends BasicEventDTO> void publishInternal(T event) {
        event.setId(IDUtil.generate());
        event.setTimestamp(System.currentTimeMillis());
        internalPublisher.publish(event);
        log.info("publish internal event id = {}", event.getId());
        //下面可以做选择性持久化逻辑
    }

    /**
     * 发布领域外事件（MQ通道）
     *
     * @param event
     * @param <T>
     */
    public <T extends BasicEventDTO> void publishExternal(String topic, T event) {
        event.setId(IDUtil.generate());
        event.setTimestamp(System.currentTimeMillis());
        externalPublisher.publish(event);
        log.info("publish external event id = {}", event.getId());
        //下面可以做选择性持久化逻辑
    }
}
