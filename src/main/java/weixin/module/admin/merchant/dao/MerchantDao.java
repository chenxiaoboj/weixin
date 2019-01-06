package weixin.module.admin.merchant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import weixin.module.admin.merchant.entity.MerchantInfo;

/**
 * @author chenx 2018-10-26 10:45
 */
public interface MerchantDao extends JpaRepository<MerchantInfo,Integer> {
}
