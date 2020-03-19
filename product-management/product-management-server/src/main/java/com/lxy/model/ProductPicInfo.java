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
 * 商品图片信息表
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("product_pic_info")
public class ProductPicInfo extends Model<ProductPicInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品图片ID
     */
    @TableId(value = "product_pic_id", type = IdType.AUTO)
    private Integer productPicId;

    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 图片描述
     */
    private String picDesc;

    /**
     * 图片URL
     */
    private String picUrl;

    /**
     * 是否主图：0.非主图1.主图
     */
    private Integer isMaster;

    /**
     * 图片排序
     */
    private Integer picOrder;

    /**
     * 图片是否有效：0无效 1有效
     */
    private Integer picStatus;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifiedTime;


    @Override
    protected Serializable pkVal() {
        return this.productPicId;
    }

}
