package weixin.module.accesscode.service.impl;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import weixin.module.accesscode.entity.AccessCodeInfo;
//import weixin.config.SchedulingTest;
import weixin.module.accesscode.dao.AccessCodeDao;
import weixin.module.accesscode.dto.Button;
import weixin.module.accesscode.dto.ClickButton;
import weixin.module.accesscode.dto.Menu;
import weixin.module.accesscode.dto.ViewButton;
import weixin.module.accesscode.service.MenuService;

/**
 * @author chenx
 */
@Service
public class MenuServiceImpl implements MenuService {

	
//	private Logger logger = LoggerFactory.getLogger(SchedulingTest.class);
	
	@Resource
	private RestTemplate restTemplate;
	
	@Resource
	private AccessCodeDao accessCodeDao;
	
	private final static String URL="https://api.weixin.qq.common/cgi-bin/menu/create?access_token=";
	

	@Override
	public String addMenu() {
		AccessCodeInfo accessCodeInfo = accessCodeDao.findOne(37);
		Menu menu = new Menu();
		ClickButton button11 = new ClickButton();
		button11.setName("click菜单");
		button11.setType("click");
		button11.setKey("11");

		ViewButton button21 = new ViewButton();
		button21.setName("CSDN文章");
		button21.setType("view");
		button21.setUrl("https://www.csdn.net/");

		ClickButton button31 = new ClickButton();
		button31.setName("扫码事件");
		button31.setType("scancode_push");
		button31.setKey("31");

		ClickButton button32 = new ClickButton();
		button32.setName("地理位置");
		button32.setType("location_select");
		button32.setKey("32");

		Button button = new Button();
		button.setName("菜单");
		button.setSub_button(new Button[] { button31, button32 });


		menu.setButton(new Button[] { button11, button21, button });
		
		Gson gson = new Gson();
		String requestJson = gson.toJson(menu);
//		logger.info(requestJson);
		 HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		 HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
		ResponseEntity<String> result =  restTemplate.postForEntity(URL+accessCodeInfo.getAccessCode(), entity, String.class);
//		logger.info(result.getBody());
		return result.getBody();
	}
}
