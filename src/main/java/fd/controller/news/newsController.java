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
    public String queryNews(String type){

        List<News> list = newsService.queryNews(type);

        return justRequest(list);
    }

    //查询某一条新闻
    @ResponseBody
    @RequestMapping(value = "/queryOnenews",produces = "application/json;charset=utf-8")
    public String queryOneNews(Integer newsId){

        News news = newsService.queryOneNews(newsId);
        Map<String,Object> map = new HashMap<>();
        map.put("data",news);
        return JSON.toJSONString(map);
    }

    //增加浏览记录
    @ResponseBody
    @RequestMapping(value = "/updateBrowse",produces = "application/json;charset=utf-8")
    public String addBrowse(Integer newsId){

        newsService.addRecordForNews(newsId);
        Map<String,Object> map = new HashMap<>();
        map.put("code",1);
        return JSON.toJSONString(map);
    }


    //增加评论数量
    @ResponseBody
    @RequestMapping(value = "/updateComment",produces = "application/json;charset=utf-8")
    public String addComment(Integer newsId){

        newsService.addCommentForNews(newsId);
        Map<String,Object> map = new HashMap<>();
        map.put("code",1);
        return JSON.toJSONString(map);
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
