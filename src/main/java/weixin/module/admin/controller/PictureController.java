package weixin.module.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import weixin.common.baseservice.ApiResult;
import weixin.module.admin.product.dto.PictureDto;
import weixin.module.admin.product.dto.PictureResponseDto;
import weixin.module.admin.product.service.PictureService;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author chenx 2018-10-30 17:32
 */
@Api(value = "PictureController", tags = "商品信息接口")
@RestController
@RequestMapping(value = "api/v1/picture")
public class PictureController {
    @Resource
    private PictureService pictureService;

    @ApiOperation(value = "上传图片接口")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ApiResult<String> uploadPicture(@RequestBody PictureDto pictureDto) {
        ApiResult<String> apiResult = new ApiResult<>();
        try {
            pictureService.savePicture(pictureDto);
            apiResult.setCode("0000");
            apiResult.setMessage("上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            apiResult.setCode("9999");
            apiResult.setMessage(e.getMessage());
        }
        return apiResult;
    }

    @ApiOperation(value = "获取图片接口(商户，用户权限)")
    @RequestMapping(value = "/getPictures", method = RequestMethod.POST)
    public ApiResult<List<PictureResponseDto>> getPictures(@RequestParam Integer merchantId, @RequestParam Integer productId) {
        ApiResult<List<PictureResponseDto>> apiResult = new ApiResult<>();
        try {
            List<PictureResponseDto> list = pictureService.getPictures(productId, merchantId);
            apiResult.setData(list);
            apiResult.setCode("0000");
            apiResult.setMessage("获取成功");
        } catch (Exception e) {
            e.printStackTrace();
            apiResult.setCode("9999");
            apiResult.setMessage(e.getMessage());
        }
        return apiResult;
    }

    @ApiOperation(value = "删除图片")
    @RequestMapping(value = "/deletePictures", method = RequestMethod.POST)
    public ApiResult<String> deletePictures(@RequestParam Integer picture) {
        ApiResult<String> apiResult = new ApiResult<>();
        try {
            pictureService.deletePicture(picture);
            apiResult.setData("success");
            apiResult.setCode("0000");
            apiResult.setMessage("获取成功");
        } catch (Exception e) {
            e.printStackTrace();
            apiResult.setCode("9999");
            apiResult.setMessage(e.getMessage());
        }
        return apiResult;
    }


}
