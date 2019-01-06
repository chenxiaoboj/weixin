package weixin.module.accesscode.component;

import javax.annotation.Resource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class HexagramByPhone {

	@Resource
	private RestTemplate restTemplate;
	
	private static final String URL = "http://www.buyiju.common/shouji/";

	public void phone() {
		HttpHeaders headers = new HttpHeaders();
		//  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		//  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
		MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
		params.add("sjhao","13122222222");
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, requestEntity, String.class);
		String body = responseEntity.getBody();
		System.out.println(body);
		
		
	}
}
