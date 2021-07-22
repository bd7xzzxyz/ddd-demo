package com.example.demo.infrastructure.dto;

import lombok.Data;

/**
 * @author baodi1
 * @description: TODO
 * @date 2021/7/21 4:07 下午
 */
@Data
public class BasicEventDTO {
    private long id;
    private long timestamp;
    private int eventType;
    private String source;
}
