package weixin.module.admin.merchant.service;

import weixin.module.admin.merchant.dto.MerchantDto;

import java.util.List;

/**
 * @author chenx 2018-10-26 14:54
 */
public interface MerchantService {
    /**
     * 保存商户信息
     *
     * @param merchantDto
     */
    void saveMerchant(MerchantDto merchantDto);

    /**
     * 删除商户
     *
     * @param id
     */
    void deleteMerchant(Integer id);

    /**
     * 获取商户列表
     *
     * @return
     */
    List<MerchantDto> getMerchants();

    /**
     * 获取商户详情信息
     *
     * @param id
     * @return
     */
    MerchantDto getOneMerchant(Integer id);


}
