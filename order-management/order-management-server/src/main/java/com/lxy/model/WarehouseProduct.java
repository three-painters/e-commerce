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
 * 商品库存表
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("warehouse_product")
public class WarehouseProduct extends Model<WarehouseProduct> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品库存ID
     */
    @TableId(value = "wp_id", type = IdType.AUTO)
    private Integer wpId;

    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 仓库ID
     */
    private Integer wId;

    /**
     * 当前商品数量
     */
    private Integer currentCnt;

    /**
     * 当前占用数据
     */
    private Integer lockCnt;

    /**
     * 在途数据
     */
    private Integer inTransitCnt;

    /**
     * 移动加权成本
     */
    private BigDecimal averageCost;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifiedTime;


    @Override
    protected Serializable pkVal() {
        return this.wpId;
    }

}
