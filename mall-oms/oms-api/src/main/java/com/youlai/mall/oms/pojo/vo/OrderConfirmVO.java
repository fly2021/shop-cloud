package com.youlai.mall.oms.pojo.vo;

import com.youlai.common.base.BaseVO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单确认页需要的数据
 */

public class OrderConfirmVO extends BaseVO {


    /**
     * 订单总额
     */
    @Setter
    private Long totalPrice;


    /**
     * 商品列表
     */
    @Getter
    @Setter
    private List<OrderItemVO> items;

    // 优惠券信息
    @Getter
    @Setter
    private List<CouponVO> coupons;

    // 积分信息
    @Getter
    @Setter
    private Integer integration;


    /**
     * 应付价格
     */
    @Setter
    private Long payAmount;

    public Long getTotalPrice() {
        Long total = 0L;
        if (items != null && items.size() > 0) {
            total = items.stream().mapToLong(OrderItemVO::getSubtotal).sum();
        }
        return total;
    }

    public Long getPayPrice() {
        Long total = 0L;
        if (items != null && items.size() > 0) {
            total = items.stream().mapToLong(OrderItemVO::getSubtotal).sum();
        }
        return total;
    }
}
