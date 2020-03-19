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
 * 用户余额变动表
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("customer_balance_log")
public class CustomerBalanceLog extends Model<CustomerBalanceLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 余额日志ID
     */
    @TableId(value = "balance_id", type = IdType.AUTO)
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


    @Override
    protected Serializable pkVal() {
        return this.balanceId;
    }

}
