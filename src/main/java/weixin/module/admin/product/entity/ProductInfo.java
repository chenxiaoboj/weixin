package weixin.module.admin.product.entity;

import weixin.common.baseentity.BaseEntity;

import javax.persistence.Entity;

/**
 * @author chenx 2018-10-26 10:17
 */
@Entity
public class ProductInfo extends BaseEntity {
    /**
     * 商户id
     */
    private Integer merchantId;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品类型
     */
    private String productType;
    /**
     * 产品状态（上架，下架）
     */
    private Integer status;
    /**
     * 产品价格
     */
    private Double productPrice;
    /**
     * 产品库存
     */
    private Integer inventory;
    /**
     * 产品详情参数1
     */
    private String parameter1;
    /**
     * 产品详情参数2
     */
    private String parameter2;
    /**
     * 产品详情参数3
     */
    private String parameter3;
    /**
     * 产品详情参数4
     */
    private String parameter4;
    /**
     * 产品详情参数5
     */
    private String parameter5;

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    public String getParameter3() {
        return parameter3;
    }

    public void setParameter3(String parameter3) {
        this.parameter3 = parameter3;
    }

    public String getParameter4() {
        return parameter4;
    }

    public void setParameter4(String parameter4) {
        this.parameter4 = parameter4;
    }

    public String getParameter5() {
        return parameter5;
    }

    public void setParameter5(String parameter5) {
        this.parameter5 = parameter5;
    }

}
