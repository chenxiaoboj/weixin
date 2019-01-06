package weixin.module.admin.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import weixin.module.admin.user.entity.UserInfo;

/**
 * @author chenx 2018-10-26 10:51
 */
public interface UserDao extends JpaRepository<UserInfo, Integer> {
}
