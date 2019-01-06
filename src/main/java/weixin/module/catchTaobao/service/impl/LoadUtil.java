package weixin.module.catchTaobao.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadUtil {

    public final static Map<String, String> cookie_map = new HashMap<>();
    public final static List<String> province = new ArrayList<>();
    public final static Map<String, String> city_map = new HashMap<>();
    public final static List<String> province_ = new ArrayList<>();

    static {
        cookie_map.put("t", "318be723ca9495d583b23708d4b1bb39");
        cookie_map.put("cookie2", "10f7c2d4a2d355751eded7c2ddc33c34");
        cookie_map.put("_tb_token_", "73d768318e935");
        cookie_map.put("cna", "W4hjE8/uYgwCAXPOOtzvC4Rs");
        cookie_map.put("_cc_", "VFC%2FuZ9ajQ%3D%3D");
        cookie_map.put("tg", "0");
        cookie_map.put("enc", "mPQTn2W6uhpkT06iX0aSZFY6nhp4F7eQ3Vb%2FDAHYsiP2IEa3Bn0tyl4wi05uJZfo%2B1rlbQ3G5njebFGN2%2FU4sA%3D%3D");
        cookie_map.put("thw", "cn");
        cookie_map.put("x", "e%3D1%26p%3D*%26s%3D0%26c%3D0%26f%3D0%26g%3D0%26t%3D0%26__ll%3D-1%26_ato%3D0");
        cookie_map.put("swfstore", "61148");
        cookie_map.put("x5sec", "7b2274616f62616f2d73686f707365617263683b32223a223132326438653630666430663431646535313034313433386166373163393531434e6937384e384645497933312b6d69726258442b674561444445354f5441334d7a67334d4463374d513d3d227d");
        cookie_map.put("whl", "-1%260%260%261543248839252");
        cookie_map.put("mt", "ci=0_0");
        cookie_map.put("v", "0");
        cookie_map.put("JSESSIONID", "E88C40A8BA6DCB0FB149A3BFD58AC8A2");
        cookie_map.put("isg", "BMjIpwr1Bxei5Gv8sI5HYLsnmTYa2S7nLbR0r4J5FMM2XWjHKoH8C15f0XWI9uRT");
        province.add("北京");
        province.add("天津");
        province.add("上海");
        province.add("重庆");
        province.add("河北");
        province.add("河南");
        province.add("云南");
        province.add("辽宁");
        province.add("黑龙江");
        province.add("湖南");
        province.add("安徽");
        province.add("山东");
        province.add("新疆");
        province.add("江苏");
        province.add("浙江");
        province.add("江西");
        province.add("湖北");
        province.add("广西");
        province.add("甘肃");
        province.add("山西");
        province.add("内蒙古");
        province.add("陕西");
        province.add("吉林");
        province.add("福建");
        province.add("贵州");
        province.add("广东");
        province.add("青海");
        province.add("西藏");
        province.add("四川");
        province.add("宁夏");
        province.add("海南");
        province.add("台湾");
        province.add("香港");
        province.add("澳门");
        city_map.put("新疆", "乌鲁木齐,克拉玛依");
        city_map.put("西藏", "拉萨");
        city_map.put("宁夏", "银川,石嘴山,吴忠,固原,中卫");
        city_map.put("内蒙古", "呼和浩特,包头,乌海,赤峰,通辽,鄂尔多斯,呼伦贝尔,巴彦淖尔,乌兰察布，");
        city_map.put("广西", "南宁,柳州,桂林,梧州,北海,崇左,来宾,贺州,玉林,百色,河池,钦州,防城港,贵港");
        city_map.put("黑龙江", "哈尔滨,大庆,齐齐哈尔,佳木斯,鸡西,鹤岗,双鸭山,牡丹江,伊春,七台河,黑河,绥化");
        city_map.put("吉林", "长春,吉林,四平,辽源,通化,白山,松原,白城");
        city_map.put("辽宁", "沈阳,大连,鞍山,抚顺,本溪,丹东,锦州,营口,阜新,辽阳,盘锦,铁岭,朝阳,葫芦岛");
        city_map.put("河北", "石家庄,唐山,邯郸,秦皇岛,保定,张家口,承德,廊坊,沧州,衡水,邢台");
        city_map.put("山东", "济南,青岛,淄博,枣庄,东营,烟台,潍坊,济宁,泰安,威海,日照,莱芜,临沂,德州,聊城,菏泽,滨州");
        city_map.put("江苏", "南京,镇江,常州,无锡,苏州,徐州,连云港,淮安,盐城,扬州,泰州,南通,宿迁");
        city_map.put("安徽", "合肥,蚌埠,芜湖,淮南,亳州,阜阳,淮北,宿州,滁州,安庆,巢湖,马鞍山,宣城,黄山,池州,铜陵");
        city_map.put("浙江", "杭州,嘉兴,湖州,宁波,金华,温州,丽水,绍兴,衢州,舟山,台州");
        city_map.put("福建", "福州,厦门,泉州,三明,南平,漳州,莆田,宁德,龙岩");
        city_map.put("广东", "广州,深圳,汕头,惠州,珠海,揭阳,佛山,河源,阳江,茂名,湛江,梅州,肇庆,韶关,潮州,东莞,中山,清远,江门,汕尾,云浮");
        city_map.put("海南", "海口,三亚");
        city_map.put("云南", "昆明,曲靖,玉溪,保山,昭通,丽江,普洱,临沧");
        city_map.put("贵州", "贵阳,六盘水,遵义,安顺");
        city_map.put("四川", "成都,绵阳,德阳,广元,自贡,攀枝花,乐山,南充,内江,遂宁,广安,泸州,达州,眉山,宜宾,雅安,资阳");
        city_map.put("湖南", "长沙,株洲,湘潭,衡阳,岳阳,郴州,永州,邵阳,怀化,常德,益阳,张家界,娄底");
        city_map.put("湖北", "武汉,襄樊,宜昌,黄石,鄂州,随州,荆州,荆门,十堰,孝感,黄冈,咸宁");
        city_map.put("河南", "郑州,洛阳,开封,漯河,安阳,新乡,周口,三门峡,焦作,平顶山,信阳,南阳,鹤壁,濮阳,许昌,商丘,驻马店");
        city_map.put("山西", "太原,大同,忻州,阳泉,长治,晋城,朔州,晋中,运城,临汾,吕梁");
        city_map.put("陕西", "西安,咸阳,铜川,延安,宝鸡,渭南,汉中,安康,商洛,榆林");
        city_map.put("甘肃", "兰州,天水,平凉,酒泉,嘉峪关,金昌,白银,武威,张掖,庆阳,定西,陇南");
        city_map.put("青海", "西宁");
        city_map.put("江西", "南昌,九江,赣州,吉安,鹰潭,上饶,萍乡,景德镇,新余,宜春,抚州");
        city_map.put("台湾", "台北,台中,基隆,高雄,台南,新竹,嘉义");
        province_.add("北京");
        province_.add("天津");
        province_.add("上海");
        province_.add("重庆");
        province_.add("香港");
        province_.add("澳门");
    }


    public static void main(String[] args) {
        Document document = null;
        try {
            document = Jsoup.connect("https://shopsearch.taobao.com/search?app=shopsearch&q=安全网+建筑工地&js=1&initiative_id=staobaoz_20181126&ie=utf8&sort=credit-desc&isb=0&shop_type=&ratesum=&loc=&s=2780")
                    .cookies(cookie_map)
//                    .proxy("", 1)
                    .get();
            Element element1 = document.head().select("script").get(5);
            String date = element1.getAllElements().get(0).childNode(0).toString();
            String date1 = date.split("}};")[0].replace("g_page_config =", "") + "}}";
            Gson gson = new Gson();
            JSONObject jsonObject = gson.fromJson(date1, JSONObject.class);
            //店铺信息
            JSONArray shopItems = jsonObject.getJSONObject("mods").getJSONObject("shoplist").getJSONObject("data").getJSONArray("shopItems");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}