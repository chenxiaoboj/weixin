package weixin.module.admin.product.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import weixin.module.admin.product.component.UploadFile;
import weixin.module.admin.product.dao.PictureDao;
import weixin.module.admin.product.dto.PictureDto;
import weixin.module.admin.product.dto.PictureResponseDto;
import weixin.module.admin.product.entity.PictureInfo;
import weixin.module.admin.product.service.PictureService;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * @author chenx 2018-10-30 10:55
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Value("file.basePath")
    private String basePath;

    @Resource
    private PictureDao pictureDao;

    @Resource
    private UploadFile uploadFile;

    @Override
    public void savePicture(PictureDto pictureDto) {
        List<MultipartFile> fileList = pictureDto.getFileList();
        for (MultipartFile file : fileList) {
            PictureInfo pictureInfo = new PictureInfo();
            String fileBasePath = basePath + "\\" + pictureDto.getMerchantName() + "\\" + pictureDto.getProductName() + "\\";
            String realPath = uploadFile.uploadFile(file, fileBasePath);
            pictureInfo.setCreateTime(new Date());
            pictureInfo.setCreatePerson(pictureDto.getMerchantName());
            pictureInfo.setMerchantId(pictureDto.getMerchantId());
            pictureInfo.setPath(realPath);
            pictureInfo.setProductId(pictureDto.getProductId());
            pictureInfo.setType(pictureDto.getType());
            pictureDao.save(pictureInfo);
        }

    }

    @Override
    public List<PictureResponseDto> getPictures(Integer productId, Integer merchantId) {
        List<PictureInfo> list = pictureDao.findByMerchantIdAndProductId(merchantId, productId);
        List<PictureResponseDto> resultList = new ArrayList<>();
        list.forEach(pictureInfo -> {
            PictureResponseDto pictureResponseDto = new PictureResponseDto();
            pictureResponseDto.setPictureId(pictureInfo.getId());
            pictureResponseDto.setPath(pictureInfo.getPath());
            pictureResponseDto.setType(pictureInfo.getType());
            resultList.add(pictureResponseDto);
        });
        return resultList;
    }

    @Override
    public void deletePicture(Integer id) {
        pictureDao.delete(id);
    }


}
