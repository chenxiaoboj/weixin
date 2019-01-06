package weixin.module.admin.coupon.entity;

import weixin.common.baseentity.BaseEntity;

import javax.persistence.Entity;

@Entity
public class CouponInfo extends BaseEntity {

    /**
     * 商户id
     */
    private Integer merchantId;
    /**
     * 产品ID（通用的为null）
     */
    private Integer productId;
    /**
     * 规格(优惠券规格)
     */
    private String specification;
    /**
     * 发布数量
     */
    private Integer count;
    /**
     * 说明（某部分商品适用）
     */
    private String description;

    /**
     * 状态(上下架)
     */
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
