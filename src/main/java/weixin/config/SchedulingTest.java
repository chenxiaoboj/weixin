//package weixin.config;
//
//import java.util.HashMap;
//import java.util.Map;
//import javax.annotation.Resource;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//import com.alibaba.fastjson.JSONObject;
//import com.google.gson.Gson;
//import weixin.module.accesscode.entity.AccessCodeInfo;
//import weixin.module.accesscode.service.AccessCodeService;
//
///**
// * 定时任务配置类
// *
// * @author chenx
// */
//@Component
//public class SchedulingTest {
//
//	@Resource
//	private AccessCodeService accessCodeService;
//
//	@Resource
//	private RestTemplate restTemplate;
//
//	private Logger logger = LoggerFactory.getLogger(SchedulingTest.class);
//
//	@Value("${tenPay.appid}")
//	private String appid;
//
//	@Value("${tenPay.appsecret}")
//	private String secret;
//
//	/**
//	 *  每5秒执行一次
//	 */
//	@Scheduled(cron = "* * 2 * * ?")
//	@Async
//	public void scheduler() {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("grant_type", "client_credential");
//		map.put("appid", appid);
//		map.put("secret", secret);
//		Gson gson = new Gson();
//		//String request = gson.toJson(map);
//		ResponseEntity<String> responseEntity = restTemplate.getForEntity(
//				"https://api.weixin.qq.common/cgi-bin/token?grant_type={grant_type}&appid={appid}&secret={secret}", String.class, map);
//		String result = responseEntity.getBody();
//		logger.info(result);
//		JSONObject jsonObject = gson.fromJson(result, JSONObject.class);
//		AccessCodeInfo accessCodeInfo = new AccessCodeInfo();
//		accessCodeInfo.setAccessCode(jsonObject.getString("access_token"));
//		accessCodeInfo.setExpiresIn(String.valueOf(jsonObject.getInteger("expires_in")));
//		accessCodeService.updateToken(accessCodeInfo.getAccessCode());
//		// User user = new User();
//		// user.setUserName("张三");
//		// userService.save(user);
//		// logger.info(user.toString());
//	}
//}