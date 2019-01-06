package weixin.module.admin.coupon.service;

import weixin.module.admin.coupon.dto.CouponDto;

import java.util.List;

public interface CouponService {

    /**
     * 保存优惠券信息
     *
     * @param couponDto
     */
    void saveCoupon(CouponDto couponDto);

    /**
     * 下架优惠券
     *
     * @param id
     */
    void changeCouponStatus(Integer id, Integer status);

    /**
     * 获取优惠券列表
     *
     * @param merchantId
     * @return
     */
    List<CouponDto> getCoupons(Integer merchantId);

    /**
     * 获取优惠券详情信息
     *
     * @param id
     * @return
     */
    CouponDto getOneCoupons(Integer id);
}
