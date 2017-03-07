package fd.controller.news;

import com.alibaba.fastjson.JSON;
import fd.pojo.news.Comment;
import fd.pojo.user.User;
import fd.service.news.CommentService;
import fd.service.uses.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by syf on 2017/3/7.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    //插入
    @ResponseBody
    @RequestMapping(value = "/insertData",produces = "application/json;charset=utf-8")
    public String insertData(String mobile,String content,Integer newsId){

        //获取到当前的时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        Date date = new Date();
        String dateStr = simpleDateFormat.format(date);

        //数据存储
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setCreateTime(dateStr);
        comment.setNewsId(newsId);
        comment.setUserMobile(mobile);

        boolean result = commentService.insertComment(comment);
        Map<String,Object> map = new HashMap<>();
        if (result){
            map.put("code",1);
            return JSON.toJSONString(map);
        }

        map.put("code",-1);
        return JSON.toJSONString(map);
    }

    //查询
    @ResponseBody
    @RequestMapping(value = "/queryData",produces = "application/json;charset=utf-8")
    public String queryData(Integer newsId){

        List<Comment> list = commentService.queryComment(newsId);
        Map<String,Object> map = new HashMap<>();
        if (list.size() <= 0){
            map.put("code",-1);
            return JSON.toJSONString(map);
        }

        //有数据
        List list1 = new ArrayList();
        for(int i = 0;i < list.size();i ++){

            Comment comment = list.get(i);
            User user = userService.queryForMobile(comment.getUserMobile());
            Map<String,Object> objectMap = new HashMap<>();
            objectMap.put("commentId",comment.getCommentId());
            objectMap.put("content",comment.getContent());
            objectMap.put("createTime",comment.getCreateTime());
            objectMap.put("nameStr",user.getUserName());
            objectMap.put("picUrl",user.getUserIcon());
            list1.add(objectMap);
        }

        if (list1.size() <= 0){
            map.put("code",-1);
            return JSON.toJSONString(map);
        }

        map.put("code",1);
        map.put("data",list1);
        return JSON.toJSONString(map);
    }
}
