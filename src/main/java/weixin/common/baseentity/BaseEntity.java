package weixin.common.baseentity;

import weixin.common.interfaces.GsUserInfoUtils;
import weixin.common.utils.SpringUtil;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author chenx 2018-10-12 18:05
 */
@MappedSuperclass
public class BaseEntity extends BaseIdEntity {
    private static final long serialVersionUID = 7631091866378801073L;
    private String remarks;
    private String createPerson;
    private Date createTime;
    private String modifyPerson;
    private Date modifyTime;
    private String delFlag;
    public static final String TRUE = "1";
    public static final String FALSE = "0";

    public BaseEntity() {
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Column(
            length = 1
    )
    public String getDelFlag() {
        return this.delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @PrePersist
    public void prePersist() {
        this.createTime = new Date();

        try {
            GsUserInfoUtils gsUserInfoUtils = (GsUserInfoUtils) SpringUtil.getBean(GsUserInfoUtils.class);
            if (gsUserInfoUtils != null) {
                this.createPerson = gsUserInfoUtils.getUserId();
            }
        } catch (Exception var2) {
            ;
        }

        this.delFlag = "0";
    }

    @PreUpdate
    public void preUpdate() {
        this.modifyTime = new Date();
        this.createTime = new Date();

        try {
            GsUserInfoUtils gsUserInfoUtils = (GsUserInfoUtils) SpringUtil.getBean(GsUserInfoUtils.class);
            if (gsUserInfoUtils != null) {
                this.modifyPerson = gsUserInfoUtils.getUserId();
            }
        } catch (Exception var2) {
            ;
        }

    }

    @Column(
            length = 32
    )
    public String getCreatePerson() {
        return this.createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    @Column(
            length = 32
    )
    public String getModifyPerson() {
        return this.modifyPerson;
    }

    public void setModifyPerson(String modifyPerson) {
        this.modifyPerson = modifyPerson;
    }
}
