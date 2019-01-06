package weixin.module.admin.product.entity;

import weixin.common.baseentity.BaseEntity;

import javax.persistence.Entity;

/**
 * @author chenx 2018-10-30 10:34
 */
@Entity
public class PictureInfo extends BaseEntity {
    /**
     * 产品id
     */
    private Integer productId;
    /**
     * 商户id
     */
    private Integer merchantId;
    /**
     * 图片地址
     */
    private String path;
    /**
     * 图片类型（轮播图，详情图）
     */
    private String type;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
