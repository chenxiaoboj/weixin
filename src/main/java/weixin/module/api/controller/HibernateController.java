package weixin.module.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import weixin.module.accesscode.dto.ResultDto;
import weixin.module.accesscode.service.MenuService;
import weixin.module.catchTaobao.entity.KeyWorldInfo;
import weixin.module.catchTaobao.service.CatchDate;
import weixin.module.pay.dto.PayDto;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenx
 */
@Api(value = "HibernateController", tags = "测试")
@RestController
@RequestMapping(value = "rest/api/hibernate")
public class HibernateController {


    @Resource
    private RestTemplate restTemplate;
    @Resource
    private CatchDate catchDate;

    @Autowired
    private MenuService menuService;

    private static final String URL = "http://www.buyiju.common/suangua/";


    @ApiOperation(value = "测试接口方法2")
    @RequestMapping(value = "/selectUser", method = RequestMethod.GET)
    public List<ResultDto> getUser(@RequestParam String string) {
        List<ResultDto> listResult = new ArrayList<>();
        return listResult;
    }

    @ApiOperation(value = "测试接口方法1")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public String getUserById(@RequestBody PayDto payDto) {
//        return menuService.addMenu();
        return "666";
    }

    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public List<KeyWorldInfo> getKeyWord(@RequestParam Integer begin, @RequestParam Integer end) {
        return catchDate.catchDate(begin, end);
    }


}
