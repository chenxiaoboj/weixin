package weixin.module.admin.coupon.service.impl;


import org.springframework.stereotype.Service;
import weixin.module.admin.coupon.dao.CouponDao;
import weixin.module.admin.coupon.dto.CouponDto;
import weixin.module.admin.coupon.entity.CouponInfo;
import weixin.module.admin.coupon.service.CouponService;
import weixin.module.constants.Constants;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Resource
    private CouponDao couponDao;

    @Override
    public void saveCoupon(CouponDto couponDto) {
        CouponInfo couponInfo = new CouponInfo();
        couponInfo.setCount(couponDto.getCount());
        couponInfo.setMerchantId(couponDto.getMerchantId());
        couponInfo.setSpecification(couponDto.getSpecification());
        couponInfo.setDescription(couponDto.getDescription());
        couponInfo.setProductId(couponDto.getProductId());
        couponInfo.setStatus(Constants.Status.SUCCESS);
        couponDao.save(couponInfo);
    }

    @Override
    public void changeCouponStatus(Integer id, Integer status) {
        couponDao.updateStatus(status, id);
    }

    @Override
    public List<CouponDto> getCoupons(Integer merchantId) {
        List<CouponInfo> list = couponDao.findByMerchantId(merchantId);
        List<CouponDto> resultList = new ArrayList<>();
        list.forEach(couponInfo -> {
            CouponDto couponDto = new CouponDto();
            couponDto.setCount(couponInfo.getCount());
            couponDto.setCreateTime(couponInfo.getCreateTime());
            couponDto.setDescription(couponInfo.getDescription());
            couponDto.setId(couponInfo.getId());
            couponDto.setMerchantId(couponInfo.getMerchantId());
            couponDto.setProductId(couponInfo.getProductId());
            couponDto.setSpecification(couponInfo.getSpecification());
            couponDto.setStatus(couponInfo.getStatus());
        });
        return resultList;
    }

    @Override
    public CouponDto getOneCoupons(Integer id) {
        CouponInfo couponInfo = couponDao.getOne(id);
        CouponDto couponDto = new CouponDto();
        couponDto.setCount(couponInfo.getCount());
        couponDto.setCreateTime(couponInfo.getCreateTime());
        couponDto.setDescription(couponInfo.getDescription());
        couponDto.setId(couponInfo.getId());
        couponDto.setMerchantId(couponInfo.getMerchantId());
        couponDto.setProductId(couponInfo.getProductId());
        couponDto.setSpecification(couponInfo.getSpecification());
        couponDto.setStatus(couponInfo.getStatus());
        return couponDto;
    }
}
