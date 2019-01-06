package weixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author chenx
 */
@SpringBootApplication
@EnableScheduling
/**增加支持定时任务的注解 */
public class WechatApp {

    public static void main(String[] args) {
        SpringApplication.run(WechatApp.class, args);
    }

}


