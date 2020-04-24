package com.lxy.model;

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
 * 用户积分日志表
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("customer_point_log")
public class CustomerPointLog extends Model<CustomerPointLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 积分日志ID
     */
    @TableId(value = "point_id", type = IdType.AUTO)
    private Integer pointId;

    /**
     * 用户ID
     */
    private Integer customerId;

    /**
     * 积分来源：0订单，1登陆，2活动
     */
    private Integer source;

    /**
     * 积分来源相关编号
     */
    private Integer referNumber;

    /**
     * 变更积分数
     */
    private Integer changePoint;

    /**
     * 积分日志生成时间
     */
    private LocalDateTime createTime;


    @Override
    protected Serializable pkVal() {
        return this.pointId;
    }

}
