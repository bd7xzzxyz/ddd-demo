package com.example.demo.lifecycle.infrastructure.dto;

import com.example.demo.infrastructure.dto.BasicEventDTO;
import lombok.Data;

/**
 * @author baodi1
 * @description: TODO
 * @date 2021/7/21 5:10 下午
 */
@Data
public class SendCouponEventDTO extends BasicEventDTO {
    private long amount;
    //...其他业务属性
}
