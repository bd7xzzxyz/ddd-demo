package com.example.demo.lifecycle.domain.entity;

import com.example.demo.infrastructure.util.IDUtil;
import com.example.demo.lifecycle.domain.po.LifeCyclePO;
import com.example.demo.lifecycle.domain.vo.LifeCycleActionVO;
import lombok.Getter;

/**
 * @author baodi1
 * @description: TODO
 * @date 2021/7/21 6:41 下午
 */

@Getter
public class LifeCycleEntity {
    public static final int STATUS_SEND_COUPON = 1; //已发券状态
    public static final int TYPE_PULL_NEW = 1; //引入期
    public static final int TYPE_LOSE = 1; //流失期
    private long id;
    private int type;
    //...其他业务属性、值对象
    private LifeCycleActionVO actionVO; //执行行为值对象

    //...一些生命周期实体的单一业务逻辑，对于依赖spring注入的增删改查业务逻辑可以放到聚合或领域服务中
    private LifeCycleEntity() {

    }

    /**
     * 创建个实体
     *
     * @return
     */
    public static LifeCycleEntity create(int type) {
        LifeCycleEntity cycleEntity = new LifeCycleEntity();
        cycleEntity.id = IDUtil.generate();
        cycleEntity.type = type;
        //处理其他属性
        return cycleEntity;
    }

    /**
     * 绑定行为
     *
     * @param entity
     * @param actionVO
     * @return
     */
    public static LifeCycleEntity bindAction(LifeCycleEntity entity, LifeCycleActionVO actionVO) {
        //业务处理
        entity.actionVO = actionVO;
        return entity;
    }


    /**
     * 实体转换成持久化对象
     *
     * @param entity
     * @return
     */
    public static LifeCyclePO entityToPO(LifeCycleEntity entity) {
        //转换对象
        //这时候就可以考虑实体中的值对象是以json形式保存到字段中，还是单独生成对象
        return null;
    }

    /**
     * 持久化对象转实体
     * @param po
     * @return
     */
    public static LifeCycleEntity poToEntity(LifeCyclePO po){
        return null;
    }

}
