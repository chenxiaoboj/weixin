package weixin.module.pay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author chenx 2018-10-24 14:56
 */
@ApiModel(value = "支付信息")
public class PayDto {
    @ApiModelProperty(value = "类型")
    private String type;
    @ApiModelProperty(value = "appName")
    private String appName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
