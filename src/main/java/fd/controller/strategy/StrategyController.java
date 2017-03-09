package fd.controller.strategy;

import com.alibaba.fastjson.JSON;
import fd.pojo.strategy.Strategy;
import fd.service.strategy.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by syf on 2017/3/8.
 */
@Controller
@RequestMapping("/strategy")
public class StrategyController {

    @Autowired
    private StrategyService strategyService;

    //分类请求
    @ResponseBody
    @RequestMapping(value = "/queryType",produces = "application/json;charset=utf-8")
    public String queryType(){

        List<String> list = strategyService.queryType();
        return dataProcess(list);
    }

    //类别数据返回
    @ResponseBody
    @RequestMapping(value = "/queryDataForType",produces = "application/json;charset=utf-8")
    public String queryDataForType(String type){

        List<Strategy> list = strategyService.queryDataForType(type);
        return dataProcess(list);
    }

    //增加浏览
    @ResponseBody
    @RequestMapping(value = "/addRecord",produces = "application/json;charset=utf-8")
    public String addRecord(Integer strategyId){

        return boolProcess(strategyService.addRecordData(strategyId));
    }

    //增加收藏
    @ResponseBody
    @RequestMapping(value = "/addCollect",produces = "application/json;charset=utf-8")
    public String addCollect(Integer strategyId){

        return boolProcess(strategyService.addCollectData(strategyId));
    }


    //结果返回
    public String dataProcess(List list){

        Map<String,Object> map = new HashMap<>();
        if (list.size() < 0){

            map.put("code",-1);
            return JSON.toJSONString(map);
        }

        map.put("code",1);
        map.put("data",list);
        return JSON.toJSONString(map);
    }

    //bool结果返回
    public String boolProcess(boolean result){

        Map<String,Object> map = new HashMap<>();
        if (result){

            map.put("code",1);
            return JSON.toJSONString(map);
        }

        map.put("code",-1);
        return JSON.toJSONString(map);
    }
}
