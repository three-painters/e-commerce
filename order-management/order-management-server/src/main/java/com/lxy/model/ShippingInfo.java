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
 * 物流公司信息表
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("shipping_info")
public class ShippingInfo extends Model<ShippingInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "ship_id", type = IdType.AUTO)
    private Integer shipId;

    /**
     * 物流公司名称
     */
    private String shipName;

    /**
     * 物流公司联系人
     */
    private String shipContact;

    /**
     * 物流公司联系电话
     */
    private String telephone;

    /**
     * 配送价格
     */
    private BigDecimal price;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifiedTime;


    @Override
    protected Serializable pkVal() {
        return this.shipId;
    }

}
