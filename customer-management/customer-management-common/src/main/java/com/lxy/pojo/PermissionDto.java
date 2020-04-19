package com.lxy.pojo;

import lombok.Data;
import java.io.Serializable;

/**
 * <p>
 * 权限
 * </p>
 *
 * @author Donily
 * @since 2020-04-19
 */
@Data
public class PermissionDto implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 权限码
     */
    private String code;

    /**
     * 描述
     */
    private String descrpption;

    /**
     * url
     */
    private String url;

}
