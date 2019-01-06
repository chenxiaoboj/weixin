package weixin.module.admin.product.service;

import weixin.module.admin.product.dto.PictureDto;
import weixin.module.admin.product.dto.PictureResponseDto;

import java.util.List;

/**
 * @author chenx
 * @create 2018-10-30 10:55
 */
public interface PictureService {
    /**
     * 保存图片
     *
     * @param pictureDto
     */
    void savePicture(PictureDto pictureDto);

    /**
     * 根据商户id和产品id查询图片信息（商家权限）
     *
     * @param productId
     * @param merchantId
     * @return
     */
    List<PictureResponseDto> getPictures(Integer productId, Integer merchantId);

    /**
     * 删除图片
     *
     * @param id
     */
    void deletePicture(Integer id);


}
