package weixin.module.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import weixin.common.baseservice.ApiResult;
import weixin.module.admin.merchant.dto.MerchantDto;
import weixin.module.admin.merchant.service.MerchantService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenx 2018-11-04 17:45
 */
@Api(value = "PictureController", tags = "商户信息接口")
@RestController
@RequestMapping(value = "api/v1/merchant")
public class MerchantController {

    @Resource
    private MerchantService merchantService;

    @RequestMapping(value = "saveMerchant", method = RequestMethod.POST)
    @ApiOperation(value = "保存商户信息")
    @Transactional
    public ApiResult<String> saveMerchant(@RequestBody MerchantDto merchantDto) {
        ApiResult<String> apiResult = new ApiResult<>();
        try {
            merchantService.saveMerchant(merchantDto);
            apiResult.setData("success");
            apiResult.setMessage("保存成功");
            apiResult.setCode("0000");
        } catch (Exception e) {
            e.printStackTrace();
            apiResult.setData("fail");
            apiResult.setMessage("系统异常");
            apiResult.setCode("9999");
        }
        return apiResult;
    }

    @RequestMapping(value = "deleteMerchant", method = RequestMethod.GET)
    @ApiOperation(value = "删除商户信息")
    @Transactional
    public ApiResult<String> deleteMerchant(@RequestParam Integer id) {
        ApiResult<String> apiResult = new ApiResult<>();
        try {
            merchantService.deleteMerchant(id);
            apiResult.setData("success");
            apiResult.setMessage("删除成功");
            apiResult.setCode("0000");
        } catch (Exception e) {
            e.printStackTrace();
            apiResult.setData("fail");
            apiResult.setMessage("系统异常");
            apiResult.setCode("9999");
        }
        return apiResult;
    }

    @RequestMapping(value = "getMerchants", method = RequestMethod.GET)
    @ApiOperation(value = "获取商户信息列表")
    @Transactional
    public ApiResult<List<MerchantDto>> getMerchants() {
        ApiResult<List<MerchantDto>> apiResult = new ApiResult<>();
        try {
            List<MerchantDto> list = merchantService.getMerchants();
            apiResult.setData(list);
            apiResult.setMessage("保存成功");
            apiResult.setCode("0000");
        } catch (Exception e) {
            e.printStackTrace();
            apiResult.setMessage("系统异常");
            apiResult.setCode("9999");
        }
        return apiResult;
    }

    @RequestMapping(value = "getOneMerchant", method = RequestMethod.GET)
    @ApiOperation(value = "获取商户详情信息")
    @Transactional
    public ApiResult<MerchantDto> getOneMerchant(@RequestParam Integer id) {
        ApiResult<MerchantDto> apiResult = new ApiResult<>();
        try {
            MerchantDto merchantDto = merchantService.getOneMerchant(id);
            apiResult.setData(merchantDto);
            apiResult.setMessage("获取成功");
            apiResult.setCode("0000");
        } catch (Exception e) {
            e.printStackTrace();
            apiResult.setMessage("系统异常");
            apiResult.setCode("9999");
        }
        return apiResult;
    }

}
