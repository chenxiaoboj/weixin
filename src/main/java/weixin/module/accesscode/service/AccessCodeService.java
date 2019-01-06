package weixin.module.accesscode.service;

import weixin.module.accesscode.entity.AccessCodeInfo;

/**
 * @author chenx
 */
public interface AccessCodeService {

	/**
	 * 保存token
	 * @param accessCodeInfo
	 */
	void save(AccessCodeInfo accessCodeInfo);

	/**
	 * 更新token
	 * @param accessToken
	 */
	void updateToken(String accessToken);
}
