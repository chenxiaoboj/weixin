package weixin.module.admin.merchant.service.impl;

import org.springframework.stereotype.Service;
import weixin.common.baseservice.BaseService;
import weixin.module.admin.merchant.dao.MerchantDao;
import weixin.module.admin.merchant.dto.MerchantDto;
import weixin.module.admin.merchant.entity.MerchantInfo;
import weixin.module.admin.merchant.service.MerchantService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chenx 2018-10-26 14:54
 */
@Service
public class MerchantServiceImpl extends BaseService<MerchantServiceImpl> implements MerchantService {
    @Resource
    private MerchantDao merchantDao;

    @Override
    public void saveMerchant(MerchantDto merchantDto) {
        MerchantInfo merchantInfo = new MerchantInfo();
        merchantInfo.setId(merchantDto.getId());
        merchantInfo.setAddress(merchantDto.getAddress());
        merchantInfo.setMerchantName(merchantDto.getMerchantName());
        merchantInfo.setPhone(merchantDto.getPhone());
        merchantInfo.setRealName(merchantDto.getRealName());
        merchantInfo.setCreateTime(new Date());
        merchantDao.save(merchantInfo);
    }

    @Override
    public void deleteMerchant(Integer id) {
        merchantDao.delete(id);
    }

    @Override
    public List<MerchantDto> getMerchants() {
        List<MerchantInfo> list = merchantDao.findAll();
        List<MerchantDto> resultList = new ArrayList<>();
        list.forEach(merchantInfo -> {
            MerchantDto merchantDto = new MerchantDto();
            merchantDto.setId(merchantInfo.getId());
            merchantDto.setAddress(merchantInfo.getAddress());
            merchantDto.setMerchantName(merchantInfo.getMerchantName());
            merchantDto.setPhone(merchantInfo.getPhone());
            merchantDto.setRealName(merchantInfo.getRealName());
            merchantDto.setCreateTime(merchantInfo.getCreateTime());
            resultList.add(merchantDto);
        });
        return resultList;
    }

    @Override
    public MerchantDto getOneMerchant(Integer id) {
        MerchantInfo merchantInfo = merchantDao.getOne(id);
        MerchantDto merchantDto = new MerchantDto();
        merchantDto.setId(merchantInfo.getId());
        merchantDto.setAddress(merchantInfo.getAddress());
        merchantDto.setMerchantName(merchantInfo.getMerchantName());
        merchantDto.setPhone(merchantInfo.getPhone());
        merchantDto.setRealName(merchantInfo.getRealName());
        merchantDto.setCreateTime(merchantInfo.getCreateTime());
        return merchantDto;
    }
}
