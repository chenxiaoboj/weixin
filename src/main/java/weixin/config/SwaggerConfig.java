package weixin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import weixin.module.constants.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenx 2018-10-24 10:30
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    @Bean
    public Docket api() {
        List<Parameter> aParameters = new ArrayList<Parameter>();
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        aParameters.add(parameterBuilder.parameterType("header")
                .name(Constants.HeaderAttr.HEADER_DEVICEID)
                .description("deviceId")
                .modelRef(new ModelRef("string"))
                .required(true)
                .build()
        );
        aParameters.add(parameterBuilder.parameterType("header")
                .name("Gs-Authorization-Token")
                .description("JWTTOKEN")
                .modelRef(new ModelRef("string"))
                .required(false)
                .build());
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/api/v.*"))
                .build()
                .apiInfo(apiInfo())
                .globalOperationParameters(aParameters);
    }

    @Bean
    public Docket restApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("rest")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/rest/api/.*"))
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("陈晓波的Swagger")
                .termsOfServiceUrl("192.168.100.44:8089")
                .contact("sunf")
                .version("1.0")
                .build();
    }

}
