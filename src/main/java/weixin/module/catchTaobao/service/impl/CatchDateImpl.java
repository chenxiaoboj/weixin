package weixin.module.catchTaobao.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import weixin.module.catchTaobao.dao.KeyWordDao;
import weixin.module.catchTaobao.entity.KeyWorldInfo;
import weixin.module.catchTaobao.service.CatchDate;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CatchDateImpl implements CatchDate {

    @Resource
    private KeyWordDao keyWordDao;

    @Override
    public List<KeyWorldInfo> catchDate(Integer begin, Integer end) {
        return keyWordDao.findPageKeyWord(begin, end);
    }


}
