package com.lxy.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户余额变动
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CustomerBalanceLogPojo {

    private static final long serialVersionUID = 1L;

    /**
     * 余额日志ID
     */
    private Integer balanceId;

    /**
     * 用户ID
     */
    private Integer customerId;

    /**
     * 记录来源：1订单，2退货单
     */
    private Integer source;

    /**
     * 相关单据ID
     */
    private Integer sourceSn;

    /**
     * 记录生成时间
     */
    private LocalDateTime createTime;

    /**
     * 变动金额
     */
    private BigDecimal amount;


}
