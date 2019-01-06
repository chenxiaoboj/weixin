package weixin.module.accesscode.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import weixin.module.accesscode.dao.AccessCodeDao;
import weixin.module.accesscode.entity.AccessCodeInfo;
import weixin.module.accesscode.service.AccessCodeService;

/**
 * @author chenx
 */
@Service
public class AccessCodeServiceImpl implements AccessCodeService {

    @Resource
    private AccessCodeDao accessCodeDao;

    @Override
    public void save(AccessCodeInfo accessCodeInfo) {

        accessCodeDao.save(accessCodeInfo);
    }

    @Override
    public void updateToken(String accessToken) {
        accessCodeDao.updateToken(accessToken);
    }

}
