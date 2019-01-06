package weixin.module.admin.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import weixin.module.admin.product.entity.ProductInfo;

import java.util.List;

/**
 * @author chenx
 * @create 2018-10-26 10:49
 */
public interface ProductDao extends JpaRepository<ProductInfo,Integer> {

    ProductInfo findByIdAndMerchantId(Integer id,Integer merchantId);

    List<ProductInfo> findByMerchantId(Integer mechantId);

}
