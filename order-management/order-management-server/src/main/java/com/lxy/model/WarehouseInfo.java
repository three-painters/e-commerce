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
 * 仓库信息表
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("warehouse_info")
public class WarehouseInfo extends Model<WarehouseInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 仓库ID
     */
    @TableId(value = "w_id", type = IdType.AUTO)
    private Integer wId;

    /**
     * 仓库编码
     */
    private String warehouseSn;

    /**
     * 仓库名称
     */
    private String warehoustName;

    /**
     * 仓库电话
     */
    private String warehousePhone;

    /**
     * 仓库联系人
     */
    private String contact;

    /**
     * 省
     */
    private Integer province;

    /**
     * 市
     */
    private Integer city;

    /**
     * 区
     */
    private Integer distrct;

    /**
     * 仓库地址
     */
    private String address;

    /**
     * 仓库状态：0禁用，1启用
     */
    private Integer warehouseStatus;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifiedTime;


    @Override
    protected Serializable pkVal() {
        return this.wId;
    }

}
