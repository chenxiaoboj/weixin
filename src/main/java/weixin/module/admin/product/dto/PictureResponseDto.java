package weixin.module.admin.product.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "图片返回信息")
public class PictureResponseDto {

    @ApiModelProperty(value = "图片id")
    private Integer pictureId;
    @ApiModelProperty(value = "图片地址")
    private String path;
    @ApiModelProperty(value = "图片类型（轮播图，详情图）")
    private String type;

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
