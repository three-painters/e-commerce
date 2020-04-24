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
 * 用户信息表
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("customer_inf")
public class CustomerInf extends Model<CustomerInf> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键ID
     */
    @TableId(value = "customer_inf_id", type = IdType.AUTO)
    private Integer customerInfId;

    /**
     * customer_login表的自增ID
     */
    private Integer customerId;

    /**
     * 用户真实姓名
     */
    private String customerName;

    /**
     * 证件类型：1 身份证，2 军官证，3 护照
     */
    private Integer identityCardType;

    /**
     * 证件号码
     */
    private String identityCardNo;

    /**
     * 手机号
     */
    private Integer mobilePhone;

    /**
     * 邮箱
     */
    private String customerEmail;

    /**
     * 性别
     */
    private String gender;

    /**
     * 用户积分
     */
    private Integer userPoint;

    /**
     * 注册时间
     */
    private LocalDateTime registerTime;

    /**
     * 会员生日
     */
    private LocalDateTime birthday;

    /**
     * 会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石
     */
    private Integer customerLevel;

    /**
     * 用户余额
     */
    private BigDecimal userMoney;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifiedTime;


    @Override
    protected Serializable pkVal() {
        return this.customerInfId;
    }

}
