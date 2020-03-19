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
 * 品牌信息表
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("brand_info")
public class BrandInfo extends Model<BrandInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 品牌ID
     */
    @TableId(value = "brand_id", type = IdType.AUTO)
    private Integer brandId;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 品牌网络
     */
    private String brandWeb;

    /**
     * 品牌logo URL
     */
    private String brandLogo;

    /**
     * 品牌描述
     */
    private String brandDesc;

    /**
     * 品牌状态,0禁用,1启用
     */
    private Integer brandStatus;

    /**
     * 排序
     */
    private Integer brandOrder;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifiedTime;


    @Override
    protected Serializable pkVal() {
        return this.brandId;
    }

}
