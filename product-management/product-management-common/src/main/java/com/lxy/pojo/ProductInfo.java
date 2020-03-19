package com.lxy.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品信息
 * </p>
 *
 * @author Donily
 * @since 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProductInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 商品编码
     */
    private String productCore;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 国条码
     */
    private String barCode;

    /**
     * 品牌表的ID
     */
    private Integer brandId;

    /**
     * 一级分类ID
     */
    private Integer oneCategoryId;

    /**
     * 二级分类ID
     */
    private Integer twoCategoryId;

    /**
     * 三级分类ID
     */
    private Integer threeCategoryId;

    /**
     * 商品的供应商ID
     */
    private Integer supplierId;

    /**
     * 商品销售价格
     */
    private BigDecimal price;

    /**
     * 商品加权平均成本
     */
    private BigDecimal averageCost;

    /**
     * 上下架状态：0下架1上架
     */
    private Integer publishStatus;

    /**
     * 审核状态：0未审核，1已审核
     */
    private Integer auditStatus;

    /**
     * 商品重量
     */
    private Float weight;

    /**
     * 商品长度
     */
    private Float length;

    /**
     * 商品高度
     */
    private Float height;

    /**
     * 商品宽度
     */
    private Float width;

    private String colorType;

    /**
     * 生产日期
     */
    private LocalDateTime productionDate;

    /**
     * 商品有效期
     */
    private Integer shelfLife;

    /**
     * 商品描述
     */
    private String descript;

    /**
     * 商品录入时间
     */
    private LocalDateTime indate;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifiedTime;


}
