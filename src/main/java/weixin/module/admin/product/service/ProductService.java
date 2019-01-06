package weixin.module.admin.product.service;

import weixin.module.admin.product.dto.ProductDto;

import java.util.List;

/**
 * @author chenx
 * @create 2018-10-26 14:52
 */
public interface ProductService {
    /**
     * 上传商品
     *
     * @param productDto
     */
    void saveProduct(ProductDto productDto);

    /**
     * 上架下架商品
     *
     * @param id
     * @param merchantId
     * @param status
     */
    void changeProductStatus(Integer id, Integer merchantId, Integer status);

    /**
     * 获取所有商品（超级管理员）
     *
     * @return
     */
    List<ProductDto> findAllProduct();

    /**
     * 获取商户下的商品信息（商户权限）
     *
     * @param merchantId
     * @return
     */
    List<ProductDto> findAllProductByMerchant(Integer merchantId);

    /**
     * 获取商品详情
     *
     * @param id
     * @return
     */
    ProductDto getOne(Integer id);

}
