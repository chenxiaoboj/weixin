package weixin.module.admin.user.entity;

import weixin.common.baseentity.BaseEntity;

import javax.persistence.Entity;

/**
 * @author chenx 2018-10-26 10:43
 */
@Entity
public class UserInfo extends BaseEntity {

    private String username;
    private String password;
    private String authority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
