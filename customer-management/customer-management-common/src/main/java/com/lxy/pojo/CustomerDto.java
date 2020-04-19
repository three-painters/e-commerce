package com.lxy.pojo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CustomerDto implements Serializable {
    private static final long serialVersionUID = -2768171298746912439L;

    //用户状态正常
    public static final int USER_STATUS_NORMAL = 0;
    //用户状态 被删除
    public static final int USER_STATUS_DELETE = 1;

    /**
     * 用户ID
     */
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


}
