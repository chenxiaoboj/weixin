package weixin.module.admin.product.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Component
public class UploadFile {

    private static final Logger logger = LoggerFactory.getLogger(UploadFile.class);

    public String uploadFile(MultipartFile file, String basePath) {
        //保存时的文件名
        String dateName = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "") + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        System.out.println(dateName);
        File basePath1 = new File(basePath);
        if (basePath1.getParentFile().exists()) {
            basePath1.mkdir();
        } else {
            //判断路径是否存在，不存在则创建文件路径
            basePath1.mkdirs();
        }
        //保存文件的绝对路径
        String filePath = basePath + "\\" + dateName;
        System.out.println("绝对路径:" + filePath);
        File newFile = new File(filePath);
        try {
            //MultipartFile的方法直接写文件
            file.transferTo(newFile);
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
