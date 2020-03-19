package com.lxy.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单详情表
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("order_detail")
public class OrderDetail extends Model<OrderDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单详情表ID
     */
    @TableId(value = "order_detail_id", type = IdType.AUTO)
    private Integer orderDetailId;

    /**
     * 订单表ID
     */
    private Integer orderId;

    /**
     * 订单商品ID
     */
    private Integer productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 购买商品数量
     */
    private Integer productCnt;

    /**
     * 购买商品单价
     */
    private BigDecimal productPrice;

    /**
     * 平均成本价格
     */
    private BigDecimal averageCost;

    /**
     * 商品重量
     */
    private Float weight;

    /**
     * 优惠分摊金额
     */
    private BigDecimal feeMoney;

    /**
     * 仓库ID
     */
    private Integer wId;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifiedTime;


    @Override
    protected Serializable pkVal() {
        return this.orderDetailId;
    }

}
