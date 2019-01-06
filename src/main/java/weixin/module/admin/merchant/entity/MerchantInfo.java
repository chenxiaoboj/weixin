package weixin.module.admin.merchant.entity;

import weixin.common.baseentity.BaseEntity;

import javax.persistence.Entity;

/**
 * @author chenx 2018-10-26 10:27
 * 商户信息
 */
@Entity
public class MerchantInfo extends BaseEntity {
    /**
     * 商户名称
     */
    private String merchantName;
    /**
     * 用户名
     */
    private String realName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 商户地址
     */
    private String address;

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
