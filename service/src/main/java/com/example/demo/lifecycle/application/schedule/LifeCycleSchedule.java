package com.example.demo.lifecycle.application.schedule;

import com.example.demo.lifecycle.domain.aggregate.LifeCycleAggregate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author baodi1
 * @description: TODO
 * @date 2021/7/22 2:15 下午
 */
@Component
//可以用分布式调度，这里用spring schedule 模拟
public class LifeCycleSchedule {
    private final LifeCycleAggregate lifeCycleAggregate;

    public LifeCycleSchedule(LifeCycleAggregate lifeCycleAggregate) {
        this.lifeCycleAggregate = lifeCycleAggregate;
    }

    @Scheduled(cron = "")
    //引入期
    public void generatePullNew() {
        lifeCycleAggregate.generatePullNew();
    }

}
