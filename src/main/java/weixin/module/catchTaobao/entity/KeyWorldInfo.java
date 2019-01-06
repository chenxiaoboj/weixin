package weixin.module.catchTaobao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author chenx 2018-11-29 13:52
 */
@Entity
public class KeyWorldInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date createTime;
    private String keyWorld;
    private String parentKey;

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getKeyWorld() {
        return keyWorld;
    }

    public void setKeyWorld(String keyWorld) {
        this.keyWorld = keyWorld;
    }
}

