package fd.controller.user;

import com.alibaba.fastjson.JSON;
import fd.pojo.strategy.Strategy;
import fd.pojo.user.StrategyCollect;
import fd.service.strategy.StrategyService;
import fd.service.uses.StrategyCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by syf on 2017/3/9.
 */
@Controller
@RequestMapping("/strategyCollect")
public class StrategyCollectController {


    @Autowired
    private StrategyCollectService strategyCollectService;
    @Autowired
    private StrategyService strategyService;
    //插入
    @ResponseBody
    @RequestMapping(value = "/insertData",produces = "application/json;charset=utf-8")
    public String insertData(String mobile,Integer strategyId){

        Boolean result = strategyCollectService.insertCollect(mobile,strategyId);
        Map<String,Object> map = new HashMap<>();
        if (result){
            map.put("code",1);
            return JSON.toJSONString(map);
        }
        map.put("code",-1);
        return JSON.toJSONString(map);
    }

    //查看
    @ResponseBody
    @RequestMapping(value = "/queryData",produces = "application/json;charset=utf-8")
    public String queryData(String mobile){

        //首先获取到收藏表
        List<StrategyCollect> list = strategyCollectService.queryCollect(mobile);
        Map<String,Object> map = new HashMap<>();
        //如果没有收藏数据
        if (list.size() <= 0){
            map.put("code",-1);
            return JSON.toJSONString(map);
        }

        //开始解析收藏数据
        List newsList = new ArrayList<>();
        for(int i = 0;i <list.size();i ++){

            StrategyCollect collect = list.get(i);
            //获取对应的新闻
            System.out.print("newId=" + collect.getStrategyId());
            Strategy strategy = strategyService.queryOneData(collect.getStrategyId());
            if(strategy != null){

                Map<String,Object> objectMap = new HashMap<>();
                objectMap.put("collectId",collect.getCollectId());
                objectMap.put("strategyId",strategy.getTitle());
                objectMap.put("strategyImage",strategy.getImage());
                objectMap.put("strategyUrl",strategy.getUrl());
                newsList.add(objectMap);
            }
        }

        //判断新闻list是否有数据
        if (newsList.size() <= 0){
            map.put("code",-1);
            return JSON.toJSONString(map);
        }

        map.put("code",1);
        map.put("data",newsList);
        return JSON.toJSONString(map);
    }

    //删除
    @ResponseBody
    @RequestMapping(value = "/deleteData",produces = "application/json;charset=utf-8")
    public String deleteData(String mobile,Integer collectId){

        Boolean result = strategyCollectService.deleteCollect(mobile,collectId);
        Map<String,Object> map = new HashMap<>();
        if (result){
            map.put("code",1);
            return JSON.toJSONString(map);
        }
        map.put("code",-1);
        return JSON.toJSONString(map);
    }

    //查询单个
    @ResponseBody
    @RequestMapping(value = "/queryOneCollect",produces = "application/json;charset=utf-8")
    public String queryOneCollect(Integer strategyId){

        StrategyCollect collect = strategyCollectService.queryOneCollect(strategyId);

        Map<String,Object> map = new HashMap<>();
        if (collect != null){
            map.put("code",1);
            map.put("data",collect);
            return JSON.toJSONString(map);
        }

        map.put("code",-1);
        return JSON.toJSONString(map);
    }
}
