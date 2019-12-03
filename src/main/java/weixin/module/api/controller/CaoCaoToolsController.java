package weixin.module.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import weixin.demo.WechatTool;
import weixin.demo.WechatTool2;
import weixin.module.accesscode.dto.ResultDto;
import weixin.module.accesscode.service.MenuService;
import weixin.module.catchTaobao.entity.KeyWorldInfo;
import weixin.module.catchTaobao.service.CatchDate;
import weixin.module.pay.dto.PayDto;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenx
 */
@Api(value = "CaoCaoToolsController", tags = "曹操工具接口")
@RestController
@RequestMapping(value = "rest/api/hibernate")
public class CaoCaoToolsController {

    @ApiOperation(value = "头条编辑")
    @PostMapping(value = "toutiao")
    public void toutiao(@RequestParam MultipartFile multipartFile, HttpServletResponse response) {
        WechatTool wechatTool = new WechatTool();
        //设置下载时客户端Excel的名称
        String fileName = LocalDate.now().toString();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".txt");
        OutputStream os = null;
        String content = wechatTool.content(wechatTool.readExcel(multipartFile));
        try {
            os = response.getOutputStream();
            os.write(content.getBytes());
            os.flush();
            os.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "次条编辑")
    @PostMapping(value = "zqcitiao")
    public void zqcitiao(@RequestParam MultipartFile multipartFile, HttpServletResponse response) {
        WechatTool2 wechatTool2 = new WechatTool2();
        //设置下载时客户端Excel的名称
        String fileName = LocalDate.now().toString();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".txt");
        OutputStream os = null;
        String content = wechatTool2.getResult(wechatTool2.readExcel(multipartFile));
        try {
            os = response.getOutputStream();
            os.write(content.getBytes());
            os.flush();
            os.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "上传信息Excel表格")
    @PostMapping(value = "uploadFile")
    public void uploadFile(@RequestParam MultipartFile multipartFile) {


    }

    @ApiOperation(value = "获取信息列表")
    @PostMapping(value = "getAll")
    public void getAll() {

    }

    @ApiOperation(value = "批量打标记")
    @PostMapping(value = "playTag")
    public void playTag() {

    }

    @ApiOperation(value = "获取标记列表")
    @PostMapping(value = "getAllTagList")
    public void getAllTagList() {

    }

}
