package weixin.module.accesscode.entity;


import weixin.common.baseentity.BaseIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author chenx
 */
@Entity
public class AccessCodeInfo extends BaseIdEntity {

    private String accessCode;
    private String expiresIn;

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Column(name = "access_code", length = 512)
    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

}
