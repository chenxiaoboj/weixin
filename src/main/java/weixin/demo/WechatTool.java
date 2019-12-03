package weixin.demo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * @author win10 2019-11-13 17:21
 */
public class WechatTool {

    public static final String HEAD_HTML = "<section data-role=\"outer\" label=\"Powered by 135editor.com\" style=\"white-space: normal;font-size: 16px;\"><section class=\"_135editor\" data-tools=\"135编辑器\" data-id=\"86233\"><section style=\"text-align: center;\"><section style=\"display: inline-block;\"><img class=\"_135editor\" data-ratio=\"0.6666666666666666\" data-type=\"gif\" data-w=\"756\" data-src=\"https://mmbiz.qlogo.cn/mmbiz_gif/fgnkxfGnnkTsFIKTC7au8UJRWwhL6TasRmMHLLRkmuF4aooYsiay0XCY5crNPotiakAup4bCoduqI1YSZdh7VDDw/640?wx_fmt=gif\"title=\"引导关注文字\" src=\"https://mmbiz.qlogo.cn/mmbiz_gif/fgnkxfGnnkTsFIKTC7au8UJRWwhL6TasRmMHLLRkmuF4aooYsiay0XCY5crNPotiakAup4bCoduqI1YSZdh7VDDw/640?wx_fmt=gif\" /></section></section></section><p><br /></p><p style=\"text-align: center;\"><img class=\"rich_pages js_insertlocalimg\" data-cropselx1=\"0\" data-cropselx2=\"574\" data-cropsely1=\"0\" data-cropsely2=\"357\"data-ratio=\"0.6666666666666666\" data-s=\"300,640\" data-type=\"gif\" data-w=\"900\" data-src=\"https://mmbiz.qlogo.cn/mmbiz_png/Xt3bOtY0UttbrM0XVibAFOsfsQTa1kOkBicylRMjSqcicia80DVdL4hGtUe3QO2ibcPrwgu4Lu3JZUKFPD0s9l4UaRw/640?wx_fmt=gif\"style=\"height: 356px;width: 574px;\" src=\"https://mmbiz.qlogo.cn/mmbiz_png/Xt3bOtY0UttbrM0XVibAFOsfsQTa1kOkBicylRMjSqcicia80DVdL4hGtUe3QO2ibcPrwgu4Lu3JZUKFPD0s9l4UaRw/640?wx_fmt=gif\" /></p><p style=\"text-align: center;\"><br /></p></section><section data-role=\"outer\" label=\"Powered by 135editor.com\">";
    public static final String FOOT_HTML = "</section><p style=\"white-space: normal; text-align: center;\"><img class=\"rich_pages\" data-cropselx1=\"0\" data-cropselx2=\"574\" data-cropsely1=\"0\" data-cropsely2=\"286\" data-ratio=\"0.6666666666666666\"data-s=\"300,640\" data-type=\"jpeg\" data-w=\"1280\" data-src=\"https://mmbiz.qlogo.cn/mmbiz_jpg/Xt3bOtY0UtuL1ZBvPnqeicicfT7jaicRluakL1VeOJKpf8uHjDnkzaPeswGN1ibBvnHnZSfjia3iaECbkWjIcCz1mvVw/640?wx_fmt=jpeg\"style=\"height: 287px;width: 574px;\" src=\"https://mmbiz.qlogo.cn/mmbiz_jpg/Xt3bOtY0UtuL1ZBvPnqeicicfT7jaicRluakL1VeOJKpf8uHjDnkzaPeswGN1ibBvnHnZSfjia3iaECbkWjIcCz1mvVw/640?wx_fmt=jpeg\" /></p>";
    public static final String FOOT1_HTML = "<section style=\"margin-right: 16px;margin-left: 16px;line-height: 1.5em;\"><a href=\"http://mp.weixin.qq.com/s?__biz=MzI2NzE3ODk1NA==&mid=2247484128&idx=4&sn=2e02c0677209ea839be67735a82379b0&chksm=ea838445ddf40d53016f1438f633b9349e128ad0ed0d0c03ced0f467ed8a7f9bdf6142d016f9&scene=21#wechat_redirect\" target=\"_blank\" data-itemshowtype=\"0\" data-linktype=\"2\"><strong><span style=\"background-color: rgb(255, 218, 81);font-size: 14px;\">关注公众号，联系客服，免费发布信息</span></strong></a><strong><span style=\"background-color: rgb(255, 218, 81);font-size: 14px;\"></span></strong><a href=\"http://mp.weixin.qq.com/s?__biz=MzI2NzE3ODk1NA==&mid=2247484118&idx=4&sn=7a8f437a16ca5f2e0a89949bc3f17452&chksm=ea838473ddf40d65e278f96a581e739f05486023b1549bdae71a088d2e78e9b099fd4707f31b&scene=21#wechat_redirect\" target=\"_blank\" data-itemshowtype=\"0\" data-linktype=\"2\"><strong><span style=\"background-color: rgb(255, 218, 81);font-size: 14px;\"></span></strong></a></section></section>";
    public static final String HEAD1_HTML = "<section data-role=\"outer\" label=\"Powered by 135editor.com\"><section data-role=\"outer\" label=\"Powered by 135editor.com\" style=\"font-family: mp-quote, -apple-system-font, BlinkMacSystemFont, Arial, sans-serif;box-sizing: border-box;\"><section class=\"_135editor\" style=\"box-sizing: border-box;\"><section style=\"margin: 1em auto;border-top: 1px solid rgb(252, 180, 43);border-right-color: rgb(252, 180, 43);border-bottom-color: rgb(252, 180, 43);border-left-color: rgb(252, 180, 43);text-align: left;width: 574px;color: inherit;box-sizing: border-box;line-height: 1.5em;\"><section style=\"padding: 5px 10px;min-height: 32px;color: rgb(255, 255, 255);display: inline-block;border-bottom-left-radius: 10px;border-bottom-right-radius: 10px;font-size: 20px;background-color: rgb(252, 180, 43);box-sizing: border-box;\"><span style=\"letter-spacing: 1px;\"><strong data-markdown=\"#\"><span style=\"font-size: 18px;line-height: 27.9861px;border-color: rgb(252, 180, 43);border-top-style: solid;border-top-width: 1px;display: inline-block;width: 72px;\">{0}</span></strong></span></section></section></section></section></section><section data-role=\"outer\" label=\"Powered by 135editor.com\">";
    public static final String CONTENT = "<section style=\"line-height: 1.5em;text-align: justify;margin-left: 16px;margin-right: 16px;\"><span style=\"font-family: 微软雅黑;font-size: 17px;color: rgb(0, 0, 0);letter-spacing: 1px;\"><span style=\"color: rgb(255, 169, 0);letter-spacing: 0.5px;\">◆</span>&nbsp;{0}</span></section>";
    public static final String MIAN_ZE = "<p style=\"max-width: 100%;min-height: 1em;color: rgb(62, 62, 62);font-family: Helvetica Neue, Helvetica, Hiragino Sans GB, Microsoft YaHei, Arial, sans-serif;font-size: 16px;text-align: start;white-space: normal;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><br/></p ><p><span style=\"text-align: start;color: rgb(178, 178, 178);font-family: 宋体;font-size: 12px;\">免</span><span style=\"text-align: start;color: rgb(178, 178, 178);font-family: 宋体;font-size: 12px;\">责声明：</span><span style=\"text-align: start;color: rgb(178, 178, 178);font-family: 宋体;font-size: 12px;\">本平台所发布的信息、图片、电</span><span style=\"text-align: start;color: rgb(178, 178, 178);font-family: 宋体;font-size: 12px;\">话等信息，均为用户自由提供，其真实性、准确性由信息提供者负责，本平台不提供任何保证，也不承担任何法律责任。</span></p >";
    public static final List<String> TITLE_LIST = Lists.newArrayList("招&nbsp;&nbsp; 聘&nbsp;", "求&nbsp;&nbsp; 职&nbsp;", "出&nbsp;&nbsp; 租&nbsp;", "求&nbsp;&nbsp; 租&nbsp;", "买二手", "卖二手", "求&nbsp;&nbsp; 助&nbsp;");
    public static final String HUAN_HANG ="<section style=\"line-height: 1.5em;text-align: justify;margin-left: 16px;margin-right: 16px;\"><span style=\"font-family: 微软雅黑;font-size: 17px;color: rgb(0, 0, 0);letter-spacing: 1px;\">&nbsp;</span></section>";



    public static void main(String[] args) {
//        createFile(content( readExcel()));
    }

    //读取excel
    public Map<Integer,List<String>> readExcel(MultipartFile multipartFile) {
        Map<Integer,List<String>> map1 = Maps.newHashMap();
        try {
//            InputStream is = new FileInputStream("D:\\text\\1113.xls");
            InputStream is = multipartFile.getInputStream();
            POIFSFileSystem fs = new POIFSFileSystem(is);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            //遍历Sheet页
            for(int sheet=0; sheet < wb.getNumberOfSheets(); sheet++){
                List<String> contentList = Lists.newArrayList();
                HSSFSheet s = wb.getSheetAt(sheet);
                if(s == null){
                    continue;
                }
                //遍历row
                for(int row = 0; row <= s.getLastRowNum(); row++){
                    HSSFRow r = s.getRow(row);
                    if(r == null){
                        continue;
                    }
                    //遍历单元格 cell
                    for(int cell =0; cell <= r.getLastCellNum(); cell++){
                        HSSFCell c = r.getCell(cell);
                        if(c == null){
                            continue;
                        }
                        contentList.add(c.getStringCellValue());
                    }
                }
                map1.put(sheet,contentList);
            }
            if(is != null){
                is.close();
            }
            if(wb != null){
                wb.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map1;
    }

    //生成最终文件
    public void createFile(String content) {
        File file = new File("D:\\text\\today.txt");
        try {
            file.createNewFile();
            Files.write(content, file, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //编辑内容
    public String  content(Map<Integer, List<String>> map) {
        StringBuilder stringBuffer = new StringBuilder(HEAD_HTML);
        for (int i = 0; i < TITLE_LIST.size(); i++) {
            String title = TITLE_LIST.get(i);
            //编辑种类
            stringBuffer.append(MessageFormat.format(HEAD1_HTML, title));
            List<String> titleList =  map.get(i);
            titleList.forEach(s1 -> {
                stringBuffer.append(MessageFormat.format(CONTENT, s1));
                stringBuffer.append(HUAN_HANG);
            });
            stringBuffer.append(FOOT1_HTML);
        }
        stringBuffer.append(FOOT_HTML).append(MIAN_ZE);
        return stringBuffer.toString();
    }

}
