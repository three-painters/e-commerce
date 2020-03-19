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
 * 用户登陆日志表
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("customer_login_log")
public class CustomerLoginLog extends Model<CustomerLoginLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 登陆日志ID
     */
    @TableId(value = "login_id", type = IdType.AUTO)
    private Integer loginId;

    /**
     * 登陆用户ID
     */
    private Integer customerId;

    /**
     * 用户登陆时间
     */
    private LocalDateTime loginTime;

    /**
     * 登陆IP
     */
    private Integer loginIp;

    /**
     * 登陆类型：0未成功，1成功
     */
    private Integer loginType;


    @Override
    protected Serializable pkVal() {
        return this.loginId;
    }

}
