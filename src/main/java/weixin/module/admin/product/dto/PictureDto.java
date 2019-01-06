package weixin.module.admin.product.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author chenx 2018-10-30 12:47
 */
@ApiModel(value = "图片信息")
public class PictureDto {
    @ApiModelProperty(value = "图片id")
    private Integer id;
    @ApiModelProperty(value = "图片集合")
    private List<MultipartFile> fileList;
    @ApiModelProperty(value = "商户名称")
    private String merchantName;
    @ApiModelProperty(value = "产品名称")
    private String productName;
    @ApiModelProperty(value = "商户id")
    private Integer merchantId;
    @ApiModelProperty(value = "产品id")
    private Integer productId;
    @ApiModelProperty(value = "图片类型")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<MultipartFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<MultipartFile> fileList) {
        this.fileList = fileList;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
