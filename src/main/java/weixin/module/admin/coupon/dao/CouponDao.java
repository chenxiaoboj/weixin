package weixin.module.admin.coupon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import weixin.module.admin.coupon.entity.CouponInfo;

import java.util.List;

public interface CouponDao extends JpaRepository<CouponInfo, Integer> {

    /**
     * 获取商户下的优惠券信息
     *
     * @param merchantId
     * @return
     */
    List<CouponInfo> findByMerchantId(Integer merchantId);

    /**
     * 更新优惠价状态
     *
     * @param status
     * @param id
     */
    @Query(value = "update coupon_info set status = ?1 where id =?2", nativeQuery = true)
    @Modifying
    void updateStatus(Integer status, Integer id);

}
