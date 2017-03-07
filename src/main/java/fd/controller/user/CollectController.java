package fd.controller.user;

import com.alibaba.fastjson.JSON;
import fd.pojo.news.News;
import fd.pojo.user.Collect;
import fd.service.news.NewsService;
import fd.service.uses.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by syf on 2017/3/7.
 */
@Controller
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;
    @Autowired
    private NewsService newsService;

    //插入
    @ResponseBody
    @RequestMapping(value = "/insertData",produces = "application/json;charset=utf-8")
    public String insertData(String mobile,Integer newsId){

        Boolean result = collectService.insertCollect(mobile,newsId);
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
        List<Collect> list = collectService.queryCollect(mobile);
        Map<String,Object> map = new HashMap<>();
        //如果没有收藏数据
        if (list.size() <= 0){
            map.put("code",-1);
            return JSON.toJSONString(map);
        }

        //开始解析收藏数据
        List newsList = new ArrayList<>();
        for(int i = 0;i <list.size();i ++){

            Collect collect = list.get(i);
            //获取对应的新闻
            System.out.print("newId=" + collect.getNewsId());
            News news = newsService.queryOneNews(collect.getNewsId());
            if(news != null){

                Map<String,Object> objectMap = new HashMap<>();
                objectMap.put("collectId",collect.getCollectId());
                objectMap.put("newsTitle",news.getNewsTitle());
                objectMap.put("newsImage",news.getNewsImage());
                objectMap.put("newsUrl",news.getNewsUrl());
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

        Boolean result = collectService.deleteCollect(mobile,collectId);
        Map<String,Object> map = new HashMap<>();
        if (result){
            map.put("code",1);
            return JSON.toJSONString(map);
        }
        map.put("code",-1);
        return JSON.toJSONString(map);
    }
}
