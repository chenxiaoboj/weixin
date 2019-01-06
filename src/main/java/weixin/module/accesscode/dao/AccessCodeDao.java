package weixin.module.accesscode.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import weixin.module.accesscode.entity.AccessCodeInfo;

/**
 * @author chenx
 */

public interface AccessCodeDao extends CrudRepository<AccessCodeInfo, Integer> {

    /**
     * ss
     * @param accessToken
     */
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query(value = "update access_code_info set access_code=?1", nativeQuery = true)
    void updateToken(String accessToken);

}
