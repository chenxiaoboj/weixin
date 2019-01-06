package weixin.module.pay.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import weixin.common.baseentity.BaseIdEntity;

import javax.persistence.Entity;

/**
 * 微信支付参数
 *
 * @author chenx
 * @create 2018-06-15 15:11
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONE)
public class WechatPayInfo extends BaseIdEntity {

	private static final long serialVersionUID = 8720265521967235047L;

	private String delFlag;
	/**
	 * 本地app名称
	 */
	private String appName;
	/**
	 * 微信注册分配的appId
	 */
	private String appId;
	/**
	 *
	 */
	private String appSecret;
	/**
	 * 商户号
	 */
	private String mchId;
	/**
	 * 回调地址: /api/wechat/tenpayReturnMsg
	 */
	private String notifyUrl;
	/**
	 * 交易类型 :APP
	 */
	private String tradeType;
	/**
	 * 商品描述:个税管家-信用风险检测
	 */
	private String body;
	/**
	 * 打包信息 Sign=WXPay
	 */
	private String packageInfo;
	/**
	 * apikey
	 */
	private String apikey;

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getPackageInfo() {
		return packageInfo;
	}

	public void setPackageInfo(String packageInfo) {
		this.packageInfo = packageInfo;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
}
