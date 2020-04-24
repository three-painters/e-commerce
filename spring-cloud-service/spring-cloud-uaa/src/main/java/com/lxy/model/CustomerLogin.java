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
 * 用户登录表
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("customer_login")
public class CustomerLogin extends Model<CustomerLogin> {

    private static final long serialVersionUID = 1L;

    //用户状态正常
    public static final int USER_STATUS_NORMAL = 0;
    //用户状态 被删除
    public static final int USER_STATUS_DELETE = 1;

    /**
     * 用户ID
     */
    @TableId(value = "customer_id", type = IdType.AUTO)
    private Integer customerId;

    /**
     * 用户登录名
     */
    private String loginName;

    /**
     * 加密的密码
     */
    private String password;

    /**
     * 用户状态
     */
    private Integer userStatus;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifiedTime;


    @Override
    protected Serializable pkVal() {
        return this.customerId;
    }

}
