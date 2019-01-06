package weixin.module.admin.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import weixin.module.admin.product.entity.PictureInfo;

import java.util.List;

/**
 * @author chenx 2018-10-30 10:56
 */
public interface PictureDao extends JpaRepository<PictureInfo, Integer> {

    List<PictureInfo> findByMerchantIdAndProductId(Integer merchantId, Integer ProductId);
}
