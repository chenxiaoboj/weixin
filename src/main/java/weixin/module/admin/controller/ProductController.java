package weixin.module.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import weixin.common.baseservice.ApiResult;
import weixin.module.admin.product.dto.ProductDto;
import weixin.module.admin.product.service.ProductService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenx 2018-10-30 17:18
 */
@Api(value = "ProductController", tags = "商品信息接口")
@RestController
@RequestMapping(value = "api/v1/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @ApiOperation(value = "保存/修改商品信息")
    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    @Transactional
    public ApiResult<String> saveProduct(@RequestBody ProductDto productDto) {
        ApiResult<String> apiResult = new ApiResult<>();
        try {
            productService.saveProduct(productDto);
            apiResult.setCode("0000");
            apiResult.setMessage("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            apiResult.setCode("9999");
            apiResult.setMessage("系统异常");
        }
        return apiResult;
    }

    @ApiOperation(value = "商品上下架")
    @RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
    @Transactional
    public ApiResult<String> changeProductStatus(@RequestBody Integer id, Integer merchantId, Integer status) {
        ApiResult<String> apiResult = new ApiResult<>();
        try {
            productService.changeProductStatus(id, merchantId, status);
            apiResult.setCode("0000");
            apiResult.setMessage("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            apiResult.setCode("9999");
            apiResult.setMessage("系统异常");
        }
        return apiResult;
    }

    @ApiOperation(value = "获取全部商品信息(admin权限)")
    @RequestMapping(value = "/getProductList", method = RequestMethod.GET)
    public ApiResult<List<ProductDto>> getProductList() {
        ApiResult<List<ProductDto>> apiResult = new ApiResult<>();
        try {
            List<ProductDto> list = productService.findAllProduct();
            apiResult.setData(list);
            apiResult.setCode("0000");
            apiResult.setMessage("获取成功");
        } catch (Exception e) {
            e.printStackTrace();
            apiResult.setCode("9999");
            apiResult.setMessage("系统异常");
        }
        return apiResult;
    }

    @ApiOperation(value = "获取全部商品信息(商户权限)")
    @RequestMapping(value = "/getProducts", method = RequestMethod.GET)
    public ApiResult<List<ProductDto>> getProducts(@RequestParam Integer merchantId) {
        ApiResult<List<ProductDto>> apiResult = new ApiResult<>();
        try {
            List<ProductDto> list = productService.findAllProductByMerchant(merchantId);
            apiResult.setData(list);
            apiResult.setCode("0000");
            apiResult.setMessage("获取成功");
        } catch (Exception e) {
            e.printStackTrace();
            apiResult.setCode("9999");
            apiResult.setMessage("系统异常");
        }
        return apiResult;
    }

    @ApiOperation(value = "获取商品详情")
    @RequestMapping(value = "/getProduct", method = RequestMethod.GET)
    public ApiResult<ProductDto> getOne(@RequestParam Integer id) {
        ApiResult<ProductDto> apiResult = new ApiResult<>();
        try {
            ProductDto productDto = productService.getOne(id);
            apiResult.setData(productDto);
            apiResult.setCode("0000");
            apiResult.setMessage("获取成功");
        } catch (Exception e) {
            e.printStackTrace();
            apiResult.setCode("9999");
            apiResult.setMessage("系统异常");
        }
        return apiResult;
    }

}
