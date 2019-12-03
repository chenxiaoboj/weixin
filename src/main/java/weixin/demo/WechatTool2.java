package weixin.demo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import static weixin.demo.WechatTool.*;

/**
 * @author win10 2019-11-14 10:58
 */
public class WechatTool2 {


    public static final String CITIAO_HEAD = "<section data-role=\"outer\" label=\"Powered by 135editor.com\" style=\"white-space: normal;font-size: 16px;\"><section class=\"_135editor\" data-tools=\"135编辑器\" data-id=\"86233\"><section style=\"text-align: center;\"><img class=\"_135editor\" data-ratio=\"0.6666666666666666\" data-src=\"https://mmbiz.qlogo.cn/mmbiz_gif/fgnkxfGnnkTsFIKTC7au8UJRWwhL6TasRmMHLLRkmuF4aooYsiay0XCY5crNPotiakAup4bCoduqI1YSZdh7VDDw/640?wx_fmt=gif\" data-type=\"gif\" data-w=\"756\" title=\"引导关注文字\" src=\"https://mmbiz.qlogo.cn/mmbiz_gif/fgnkxfGnnkTsFIKTC7au8UJRWwhL6TasRmMHLLRkmuF4aooYsiay0XCY5crNPotiakAup4bCoduqI1YSZdh7VDDw/640?wx_fmt=gif\"/></section><p style=\"text-align: center;\"><br/></p><p style=\"text-align: center;\"><img class=\"rich_pages\" data-cropselx1=\"0\" data-cropselx2=\"574\" data-cropsely1=\"0\" data-cropsely2=\"357\" data-ratio=\"0.6666666666666666\" data-src=\"https://mmbiz.qlogo.cn/mmbiz_png/Xt3bOtY0UttbrM0XVibAFOsfsQTa1kOkBicylRMjSqcicia80DVdL4hGtUe3QO2ibcPrwgu4Lu3JZUKFPD0s9l4UaRw/640?wx_fmt=gif\" data-type=\"gif\" data-w=\"900\" style=\"height: 356px;width: 574px;\" src=\"https://mmbiz.qlogo.cn/mmbiz_png/Xt3bOtY0UttbrM0XVibAFOsfsQTa1kOkBicylRMjSqcicia80DVdL4hGtUe3QO2ibcPrwgu4Lu3JZUKFPD0s9l4UaRw/640?wx_fmt=gif\"/></p><p style=\"text-align: center;\"><br/></p></section></section>";
    public static final String CITIAO_HEAD1 = "<section data-role=\"outer\" label=\"Powered by 135editor.com\" style=\"white-space: normal;font-size: 16px;\"><section class=\"_135editor\" data-tools=\"135编辑器\" data-id=\"93521\"><section><img class=\"\" data-ratio=\"0.6666666666666666\" data-src=\"https://mmbiz.qlogo.cn/mmbiz_png/ldFaBNSkvHjHFia0o1qfImoE8v1BPsTJIV1wA5wJXAHCfF7ZdxbRsPVf3qKZibqUTdCgBzte1nYlRBMIiauN0Vmsw/640\" data-w=\"70\" style=\"width: 70px;\" src=\"https://mmbiz.qlogo.cn/mmbiz_png/ldFaBNSkvHjHFia0o1qfImoE8v1BPsTJIV1wA5wJXAHCfF7ZdxbRsPVf3qKZibqUTdCgBzte1nYlRBMIiauN0Vmsw/640\" data-type=\"png\"/></section><section class=\"135brush\" data-width=\"97%\" style=\"margin-top: -27px;margin-right: auto;margin-left: auto;padding: 1em 0.8em;width: 556.766px;background: rgb(252, 251, 238);font-size: 14px;color: rgb(63, 63, 63);letter-spacing: 1.5px;box-sizing: border-box;\"><p style=\"text-align: center;\"><strong style=\"font-family: Helvetica, Arial, sans-serif;font-size: 20px;\">{0}</strong><br/></p></section><section style=\"margin-top: -21px;display: flex;justify-content: flex-end;\"><img class=\"\" data-ratio=\"0.6666666666666666\" data-src=\"https://mmbiz.qlogo.cn/mmbiz_png/ldFaBNSkvHjHFia0o1qfImoE8v1BPsTJILfd81vALuiazxDqzcpWWdgt4GysO0kwRuicHp5SicW9MOwePvvvNpIZtg/640\" data-w=\"70\" style=\"width: 70px;\" src=\"https://mmbiz.qlogo.cn/mmbiz_png/ldFaBNSkvHjHFia0o1qfImoE8v1BPsTJILfd81vALuiazxDqzcpWWdgt4GysO0kwRuicHp5SicW9MOwePvvvNpIZtg/640\" data-type=\"png\"/></section></section></section>";
    public static final String FOOT = "<section style=\"margin-right: 16px;margin-left: 16px;white-space: normal;line-height: 1.5em;\"><span style=\"color: rgb(0, 0, 0);font-family: 微软雅黑;letter-spacing: 1px;\"></span></section><hr style=\"white-space: normal;border-style: solid;border-right-width: 0px;border-bottom-width: 0px;border-left-width: 0px;border-color: rgba(0, 0, 0, 0.1);transform-origin: 0px 0px 0px;transform: scale(1, 0.5);\"/><section style=\"margin-right: 16px;margin-left: 16px;white-space: normal;font-size: 16px;line-height: 1.5em;\"><br/></section><section data-role=\"outer\" label=\"Powered by 135editor.com\" style=\"white-space: normal;font-size: 16px;\"><section style=\"margin-right: 16px;margin-left: 16px;\"><section style=\"display: inline-block;width: 30px;\"><img class=\"\" data-ratio=\"0.6666666666666666\" data-src=\"https://mmbiz.qlogo.cn/mmbiz/yqVAqoZvDibHW4ynpBjRrolMxOZtKTiaYgT0HG1BkTeIUjfS0zrwEYVMy6Fj54m58z6pH9yWNOnFkbflRtKVicx0w/640?wx_fmt=gif\" data-type=\"gif\" data-w=\"400\" style=\"display: inline-block;vertical-align: middle;width:auto !important;max-width:100% !important;height:auto !important;\" src=\"https://mmbiz.qlogo.cn/mmbiz/yqVAqoZvDibHW4ynpBjRrolMxOZtKTiaYgT0HG1BkTeIUjfS0zrwEYVMy6Fj54m58z6pH9yWNOnFkbflRtKVicx0w/640?wx_fmt=gif\"/></section><section class=\"135brush\" data-brushtype=\"text\" style=\"margin-left: 5px;display: inline-block;vertical-align: middle;font-size: 12px;\"><p style=\"letter-spacing: 2px;\"><span style=\"color: rgb(255, 255, 255);\">添</span><span style=\"color: rgb(8, 8, 8);\">添加客服微信，曹操帮帮忙竭诚为您服务！</span></p></section></section></section><section style=\"margin-right: 16px;margin-left: 16px;white-space: normal;font-size: 16px;line-height: 1.5em;\"><br/></section><p style=\"white-space: normal; text-align: center;\"><img class=\"rich_pages\" data-cropselx1=\"0\" data-cropselx2=\"574\" data-cropsely1=\"0\" data-cropsely2=\"286\" data-ratio=\"0.6666666666666666\" data-s=\"300,640\" data-src=\"https://mmbiz.qlogo.cn/mmbiz_jpg/Xt3bOtY0UtuL1ZBvPnqeicicfT7jaicRluakL1VeOJKpf8uHjDnkzaPeswGN1ibBvnHnZSfjia3iaECbkWjIcCz1mvVw/640?wx_fmt=jpeg\" data-type=\"jpeg\" data-w=\"1280\" style=\"height: 287px;width: 574px;\" src=\"https://mmbiz.qlogo.cn/mmbiz_jpg/Xt3bOtY0UtuL1ZBvPnqeicicfT7jaicRluakL1VeOJKpf8uHjDnkzaPeswGN1ibBvnHnZSfjia3iaECbkWjIcCz1mvVw/640?wx_fmt=jpeg\"/></p>";
    public static final String CZHJ = "出&nbsp;租&nbsp;合&nbsp;辑";
    public static final String QIUZUHJ = "求&nbsp;租&nbsp;合&nbsp;辑";
    public static final String ZPHJ = "招&nbsp;聘&nbsp;合&nbsp;辑";
    public static final String QIUZHIHJ = "求&nbsp;职&nbsp;合&nbsp;辑";
    public static final String QIUGOUERSHOU = "二&nbsp;手&nbsp;求&nbsp;购";
    public static final String CHUSHOUERSHOU = "二&nbsp;手&nbsp;出&nbsp;售";

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder(CITIAO_HEAD);
        Map<String, List<String>> map = Maps.newHashMap();
        map.forEach((key, value) -> {
            if (key.contains("求职")) {
                stringBuilder.append(getContent(value, QIUZHIHJ));
            } else if (key.contains("招聘")) {
                stringBuilder.append(getContent(value, ZPHJ));
            } else if (key.contains("出租")) {
                stringBuilder.append(getContent(value, CZHJ));
            } else if (key.contains("出售")) {
                stringBuilder.append(getContent(value, CHUSHOUERSHOU));
            } else if (key.contains("求租")) {
                stringBuilder.append(getContent(value, QIUZUHJ));
            } else if (key.contains("求购")) {
                stringBuilder.append(getContent(value, QIUGOUERSHOU));
            }
        });
        stringBuilder.append(FOOT);
    }

    public String getResult(Map<String, List<String>> map) {
        StringBuilder stringBuilder = new StringBuilder(CITIAO_HEAD);
        map.forEach((key, value) -> {
            if (key.contains("求职")) {
                stringBuilder.append(getContent(value, QIUZHIHJ));
            } else if (key.contains("招聘")) {
                stringBuilder.append(getContent(value, ZPHJ));
            } else if (key.contains("出租")) {
                stringBuilder.append(getContent(value, CZHJ));
            } else if (key.contains("出售")) {
                stringBuilder.append(getContent(value, CHUSHOUERSHOU));
            } else if (key.contains("求租")) {
                stringBuilder.append(getContent(value, QIUZUHJ));
            } else if (key.contains("求购")) {
                stringBuilder.append(getContent(value, QIUGOUERSHOU));
            }
        });
        stringBuilder.append(FOOT).append(MIAN_ZE);
        return stringBuilder.toString();
    }


    public static String getContent(List<String> content, String title) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MessageFormat.format(CITIAO_HEAD1, title)).append(HUAN_HANG);
        //内容编辑
        content.forEach(s -> {
            stringBuilder.append(MessageFormat.format(CONTENT, s)).append(HUAN_HANG);
        });
        return stringBuilder.toString();
    }

    //读取excel
    public Map<String, List<String>> readExcel(MultipartFile multipartFile) {
        Map<String, List<String>> map1 = Maps.newHashMap();
        try {
            InputStream is = multipartFile.getInputStream();
            POIFSFileSystem fs = new POIFSFileSystem(is);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            //遍历Sheet页
            for (int sheet = 0; sheet < wb.getNumberOfSheets(); sheet++) {
                List<String> contentList = Lists.newArrayList();
                HSSFSheet s = wb.getSheetAt(sheet);
                if (s == null) {
                    continue;
                }
                //遍历row
                for (int row = 0; row <= s.getLastRowNum(); row++) {
                    HSSFRow r = s.getRow(row);
                    if (r == null) {
                        continue;
                    }
                    //遍历单元格 cell
                    for (int cell = 0; cell <= r.getLastCellNum(); cell++) {
                        HSSFCell c = r.getCell(cell);
                        if (c == null) {
                            continue;
                        }
                        contentList.add(c.getStringCellValue());
                    }
                }
                map1.put(s.getSheetName(), contentList);
            }
            if (is != null) {
                is.close();
            }
            if (wb != null) {
                wb.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map1;
    }


}
