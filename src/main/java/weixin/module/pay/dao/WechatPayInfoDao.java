package weixin.module.pay.dao;

import org.springframework.data.repository.CrudRepository;
import weixin.module.pay.entity.WechatPayInfo;

/**
 * @author chenx 2018-10-12 17:12
 */
public interface WechatPayInfoDao extends CrudRepository<WechatPayInfo, String> {

    /**
     * 获取商户信息
     * @param appName
     * @param delFlag
     * @return
     */
    WechatPayInfo findByAppNameAndDelFlag(String appName,String delFlag);
}
