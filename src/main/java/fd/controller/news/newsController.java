package fd.controller.news;

import com.alibaba.fastjson.JSON;
import fd.pojo.news.News;
import fd.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by syf on 2017/3/1.
 */
@Controller
@RequestMapping("/news")
public class newsController {

    @Autowired
    private NewsService newsService;

    //查询所有的新闻数据
    @ResponseBody
    @RequestMapping(value = "/querynews",produces = "application/json;charset=utf-8")
    public String queryNews(){

        List<News> list = newsService.queryNews();

        return justRequest(list);
    }



    //数据返回
    public String justRequest(List list){

        Map<String,Object> map = new HashMap<>();
        if (list.size() <= 0){

            map.put("code",-1);
            map.put("message","数据为空");
        }else {

            map.put("code",1);
            map.put("message","请求成功");
            map.put("data",list);
        }

        return JSON.toJSONString(map);
    }
}
