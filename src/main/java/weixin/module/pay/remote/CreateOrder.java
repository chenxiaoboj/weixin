package weixin.module.pay.remote;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import weixin.module.constants.CommonConstants;
import weixin.module.constants.PayConstants;
import weixin.module.pay.dao.WechatPayInfoDao;
import weixin.module.pay.entity.WechatPayInfo;
import weixin.common.utils.ArithUtil;
import weixin.common.utils.Md5Util;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @author chenx 2018-10-12 16:58
 */
public class CreateOrder {
    private static final Logger log = LoggerFactory.getLogger(CreateOrder.class);

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private WechatPayInfoDao wechatPayInfoDao;

    @Value("${tenPay.url}")
    private String url;

    @Value("${tenPay.queryUrl}")
    private String queryUrl;

    /**
     * 查询订单状态
     * return_code:SUCCESS/FAIL
     * result_code:SUCCESS
     * <p>
     * 交易状态	trade_state
     * <p>
     * SUCCESS—支付成功
     * <p>
     * REFUND—转入退款
     * <p>
     * NOTPAY—未支付
     * <p>
     * CLOSED—已关闭
     * <p>
     * REVOKED—已撤销（刷卡支付）
     * <p>
     * USERPAYING--用户支付中
     * <p>
     * PAYERROR--支付失败(其他原因，如银行返回失败)
     *
     * @param orderNo
     * @return
     */
    public Map<String, String> queryOrder(String appName, String orderNo) {
        WechatPayInfo wechatPayInfo = wechatPayInfoDao.findByAppNameAndDelFlag(appName, CommonConstants.States.FALSE);
        if (wechatPayInfo != null) {
            Map<String, String> map = new HashMap<>(5);
            map.put("appid", wechatPayInfo.getAppId());
            //微信支付分配的商户号
            map.put("mch_id", wechatPayInfo.getMchId());
            // 随机数
            map.put("nonce_str", UUID.randomUUID().toString().toUpperCase().replaceAll("-", ""));
            map.put("out_trade_no", orderNo);
            //签名
            map.put("sign", getSign(map, wechatPayInfo.getAppSecret()));

            log.info("微信支付查询订单参数信息");
            map.forEach((key, value) -> log.info("Key:{}-----Value:{}", key, value));
            String body = xmlPostRequest(map, queryUrl);
            log.info("微信支付查询订单返回消息:{}", body);
            Map<String, String> returnMap = readStringXmlOut(body);
            return returnMap;
        }
        return null;
    }

    /**
     * 发送xml Post请求
     *
     * @param map
     * @param url
     * @return
     */
    private String xmlPostRequest(Map<String, String> map, String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/xml;charset=UTF-8");
        HttpEntity<String> request = new HttpEntity<>(mapToXml(map), headers);
        List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
        converterList.remove(1);    //移除StringHttpMessageConverter
        HttpMessageConverter<?> converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converterList.add(1, converter);    //convert顺序错误会导致失败
        restTemplate.setMessageConverters(converterList);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, request, String.class);
        return responseEntity.getBody();
    }

    /**
     * 返回给前台的数据
     *
     * @param map
     * @return
     */
    private String returnPayInfo(Map<String, String> map, WechatPayInfo wechatPayInfo) {
        Map<String, String> map1 = new HashMap<>(7);
        map1.put("appid", map.get("appid"));
        map1.put("partnerid", wechatPayInfo.getMchId());
        map1.put("prepayid", map.get("prepay_id"));
        map1.put("noncestr", map.get("nonce_str"));
        map1.put("timestamp", System.currentTimeMillis() / 1000 + "");
        map1.put("package", wechatPayInfo.getPackageInfo());
        map1.put("sign", getSign(map1, wechatPayInfo.getAppSecret()));
//      map1.forEach((key, value) -> log.info("返回给前台的数据: {}----{}", key, value));
        return new Gson().toJson(map1);

    }

    /**
     * map to xml
     *
     * @param map
     * @return
     */
    private String mapToXml(Map<String, String> map) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<xml version=\"1.0\" encoding=\"utf-8\">");
        map.forEach((key, value) ->
                buffer.append("<").append(key).append(">").append(value).append("</").append(key).append(">")
        );
        buffer.append("</xml>");
        return buffer.toString();
    }

    /**
     * 签名
     *
     * @param map
     * @return
     */
    public String getSign(Map<String, String> map, String appSecret) {
        StringBuffer buffer = new StringBuffer();
        Map<String, String> sortMap = new TreeMap<>(
                Comparator.naturalOrder());
        sortMap.putAll(map);
        sortMap.forEach((key, value) ->
                buffer.append(key).append("=").append(value).append("&"));
        buffer.append("key=").append(appSecret);
        log.info("md5 sign:{}", buffer.toString());
        return Md5Util.MD5(buffer.toString()).toUpperCase();
    }

    /**
     * @param xml
     * @return Map
     * @description 将xml字符串转换成map
     */
    @SuppressWarnings("unchecked")
    private Map<String, String> readStringXmlOut(String xml) {
        Map<String, String> map = new HashMap<>();
        Document doc = null;
        // 将字符串转为XML
        try {
            doc = DocumentHelper.parseText(xml);
            Element rootElt = doc.getRootElement();
            List<Element> list = rootElt.elements();
            for (Element element : list) {
                map.put(element.getName(), element.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 通过code换取access_token
     *
     * @param code
     * @param appid
     * @return
     */
    public String accessToken(String code, String appid, String secret) {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%1$s&secret=%2$s&code=%3$s&grant_type=authorization_code";
        url = String.format(url, "wxfb51a2df541603d7", "d3da8691736f949e6167c3468027779d", code);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        JSONObject resultJson = new Gson().fromJson(responseEntity.getBody(), JSONObject.class);
        log.info("微信公众号生成 openid:{}", resultJson.toJSONString());
        if (resultJson.containsKey("openid")) {
            return resultJson.getString("openid");
        }
        return null;
    }

    /**
     * 公众号 创建订单
     *
     * @param appName
     * @param body    商品名称
     * @param orderNo
     * @param ip
     * @param price
     * @return 一个链接
     */
    public String jsApiPlaceOrder(WechatPayInfo wechatPayInfo, String appName, String body, String orderNo, String ip, Double price, String code, String openid) {
        if (wechatPayInfo != null) {
            Map<String, String> map = new HashMap<>(10);
            map.put("appid", wechatPayInfo.getAppId());
            //微信支付分配的商户号
            map.put("mch_id", wechatPayInfo.getMchId());
            // 随机数
            map.put("nonce_str", UUID.randomUUID().toString().toUpperCase().replaceAll("-", ""));
            map.put("body", StringUtils.isNotBlank(body) ? body : wechatPayInfo.getBody());
            map.put("out_trade_no", orderNo);
            //订单金额 9.9元
            map.put("total_fee", ArithUtil.convertsToInt((ArithUtil.mul(price != null ? price : 0.1, 100))) + "");
            //ip 115.199.109.43
            map.put("spbill_create_ip", ip);
            //回调地址
            map.put("notify_url", PayConstants.BASE_URL + wechatPayInfo.getNotifyUrl());
            //交易类型   MWEB
            map.put("trade_type", PayConstants.WechatPayTradeType.APPLET);
            //openid
            map.put("openid", openid);
            //签名
            map.put("sign", getSign(map, wechatPayInfo.getAppSecret()));
            log.info("微信公众号支付生成订单参数信息");
            map.forEach((key, value) -> log.info("Key:{}-----Value:{}", key, value));
            String reponseBody = xmlPostRequest(map, url);
            log.info("微信公众号支付生成订单返回消息:{}", reponseBody);
            Map<String, String> returnMap = readStringXmlOut(reponseBody);
            return returnMap.get("prepay_id");
        }
        return null;
    }

}
