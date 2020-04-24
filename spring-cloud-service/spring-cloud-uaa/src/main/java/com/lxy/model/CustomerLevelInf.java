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
 * 用户级别信息表
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("customer_level_inf")
public class CustomerLevelInf extends Model<CustomerLevelInf> {

    private static final long serialVersionUID = 1L;

    /**
     * 会员级别ID
     */
    @TableId(value = "customer_level", type = IdType.AUTO)
    private Integer customerLevel;

    /**
     * 会员级别名称
     */
    private String levelName;

    /**
     * 该级别最低积分
     */
    private Integer minPoint;

    /**
     * 该级别最高积分
     */
    private Integer maxPoint;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifiedTime;


    @Override
    protected Serializable pkVal() {
        return this.customerLevel;
    }

}
