package weixin.module.admin.coupon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "优惠券信息")
public class CouponDto {
    @ApiModelProperty(value = "优惠卷id")
    private Integer id;
    @ApiModelProperty(value = "商户id")
    private Integer merchantId;
    @ApiModelProperty(value = "产品ID（通用的为null）")
    private Integer productId;
    @ApiModelProperty(value = "规格(优惠券规格)")
    private String specification;
    @ApiModelProperty(value = "发布数量")
    private Integer count;
    @ApiModelProperty(value = "说明（某部分商品适用）")
    private String description;
    @ApiModelProperty(value = "状态(上下架)")
    private Integer status;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
