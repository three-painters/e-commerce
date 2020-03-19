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
 * 订单主表
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("order_master")
public class OrderMaster extends Model<OrderMaster> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 订单编号 yyyymmddnnnnnnnn
     */
    private Long orderSn;

    /**
     * 下单人ID
     */
    private Integer customerId;

    /**
     * 收货人姓名
     */
    private String shippingUser;

    /**
     * 省
     */
    private Integer province;

    /**
     * 市
     */
    private Integer city;

    /**
     * 区
     */
    private Integer district;

    /**
     * 地址
     */
    private String address;

    /**
     * 支付方式：1现金，2余额，3网银，4支付宝，5微信
     */
    private Integer paymentMethod;

    /**
     * 订单金额
     */
    private BigDecimal orderMoney;

    /**
     * 优惠金额
     */
    private BigDecimal districtMoney;

    /**
     * 运费金额
     */
    private BigDecimal shippingMoney;

    /**
     * 支付金额
     */
    private BigDecimal paymentMoney;

    /**
     * 快递公司名称
     */
    private String shippingCompName;

    /**
     * 快递单号
     */
    private String shippingSn;

    /**
     * 下单时间
     */
    private LocalDateTime createTime;

    /**
     * 发货时间
     */
    private LocalDateTime shippingTime;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 收货时间
     */
    private LocalDateTime receiveTime;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 订单积分
     */
    private Integer orderPoint;

    /**
     * 发票抬头
     */
    private String invoiceTime;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifiedTime;


    @Override
    protected Serializable pkVal() {
        return this.orderId;
    }

}
