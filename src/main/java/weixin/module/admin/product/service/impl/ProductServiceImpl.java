package weixin.module.admin.product.service.impl;

import org.springframework.stereotype.Service;
import weixin.common.baseservice.BaseService;
import weixin.module.admin.product.dao.PictureDao;
import weixin.module.admin.product.dao.ProductDao;
import weixin.module.admin.product.dto.ProductDto;
import weixin.module.admin.product.entity.ProductInfo;
import weixin.module.admin.product.service.ProductService;
import weixin.module.constants.Constants;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenx 2018-10-26 14:52
 */
@Service
public class ProductServiceImpl extends BaseService<ProductServiceImpl> implements ProductService {
    @Resource
    private ProductDao productDao;
    @Resource
    private PictureDao pictureDao;

    @Override
    public void saveProduct(ProductDto productDto) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName(productDto.getProductName());
        productInfo.setProductType(productDto.getProductType());
        productInfo.setStatus(Constants.Status.SUCCESS);
        productInfo.setMerchantId(productDto.getMerchantId());
        productInfo.setProductPrice(productDto.getProductPrice());
        productInfo.setCreatePerson(productDto.getMerchantId() + "");
        productInfo.setInventory(productDto.getInventory());
        productInfo.setParameter1(productDto.getParameter1());
        productInfo.setParameter2(productDto.getParameter2());
        productInfo.setParameter3(productDto.getParameter3());
        productInfo.setParameter4(productDto.getParameter4());
        productInfo.setParameter5(productDto.getParameter5());
        productDao.save(productInfo);
    }

    @Override
    public void changeProductStatus(Integer id, Integer merchantId, Integer status) {
        ProductInfo productInfo = productDao.findByIdAndMerchantId(id, merchantId);
        productInfo.setStatus(status);
        productDao.save(productInfo);
    }

    @Override
    public List<ProductDto> findAllProduct() {
        List<ProductDto> list = new ArrayList<>();
        List<ProductInfo> iterable = productDao.findAll();
        iterable.forEach(productInfo -> {
            ProductDto productDto = new ProductDto();
            productDto.setId(productInfo.getId());
            productDto.setProductName(productInfo.getProductName());
            productDto.setProductType(productInfo.getProductType());
            productDto.setStatus(productInfo.getStatus());
            productDto.setProductPrice(productInfo.getProductPrice());
            productDto.setMerchantId(productInfo.getMerchantId());
            productDto.setParameter1(productInfo.getParameter1());
            productDto.setParameter2(productInfo.getParameter2());
            productDto.setParameter3(productInfo.getParameter3());
            productDto.setParameter4(productInfo.getParameter4());
            productDto.setParameter5(productInfo.getParameter5());
            productDto.setInventory(productInfo.getInventory());
            list.add(productDto);
        });
        return list;
    }

    @Override
    public List<ProductDto> findAllProductByMerchant(Integer merchantId) {
        List<ProductInfo> list = productDao.findByMerchantId(merchantId);
        List<ProductDto> resultList = new ArrayList<>();
        list.forEach(productInfo -> {
            ProductDto productDto = new ProductDto();
            productDto.setId(productInfo.getId());
            productDto.setProductName(productInfo.getProductName());
            productDto.setProductType(productInfo.getProductType());
            productDto.setStatus(productInfo.getStatus());
            productDto.setProductPrice(productInfo.getProductPrice());
            productDto.setInventory(productInfo.getInventory());
            productDto.setMerchantId(productInfo.getMerchantId());
            productDto.setParameter1(productInfo.getParameter1());
            productDto.setParameter2(productInfo.getParameter2());
            productDto.setParameter3(productInfo.getParameter3());
            productDto.setParameter4(productInfo.getParameter4());
            productDto.setParameter5(productInfo.getParameter5());
            resultList.add(productDto);
        });
        return resultList;
    }

    @Override
    public ProductDto getOne(Integer id) {
        ProductInfo productInfo = productDao.getOne(id);
        ProductDto productDto = new ProductDto();
        productDto.setId(productInfo.getId());
        productDto.setProductName(productInfo.getProductName());
        productDto.setProductType(productInfo.getProductType());
        productDto.setStatus(productInfo.getStatus());
        productDto.setInventory(productInfo.getInventory());
        productDto.setProductPrice(productInfo.getProductPrice());
        productDto.setMerchantId(productInfo.getMerchantId());
        productDto.setParameter1(productInfo.getParameter1());
        productDto.setParameter2(productInfo.getParameter2());
        productDto.setParameter3(productInfo.getParameter3());
        productDto.setParameter4(productInfo.getParameter4());
        productDto.setParameter5(productInfo.getParameter5());
        return productDto;
    }
}
