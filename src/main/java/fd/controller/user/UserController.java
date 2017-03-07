package fd.controller.user;

import com.alibaba.fastjson.JSON;
import fd.pojo.user.User;
import fd.service.uses.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by syf on 2017/3/4.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //直接根据账号查询信息
    @ResponseBody
    @RequestMapping(value = "/queryUserMessage",produces = "application/json;charset=utf-8")
    public String queryUserMessage(String mobile){

        //开始查询
        User user = userService.queryForMobile(mobile);
        Map<String,Object> map = new HashMap<>();

        if (user != null){

            //说明有这个用户
            map.put("code",1);
            map.put("data",user);
        }else {
            map.put("code",-1);
        }

        return JSON.toJSONString(map);
    }
    //查询
    @ResponseBody
    @RequestMapping(value = "/queryUser",produces = "application/json;charset=utf-8")
    public String queryUser(String mobile,String pwd){

        //开始查询
        User user = userService.queryOneUser(mobile,pwd);
        Map<String,Object> map = new HashMap<>();

        if (user != null){

            //说明有这个用户
            map.put("code",1);
        }else {
            map.put("code",-1);
        }

        return JSON.toJSONString(map);
    }

    //插入
    @ResponseBody
    @RequestMapping(value = "/insertUser",produces = "application/json;charset=utf-8")
    public String insertUser(String mobile,String pwd){

        Map<String,Object> map = new HashMap<>();
        //判断是否已经有这个用户
        User user = userService.queryForMobile(mobile);
        if (user != null){
            map.put("code",-1);
            map.put("message","手机号已注册");
            return JSON.toJSONString(map);
        }
        //插入数据
        boolean result = userService.insertUser(mobile,pwd);
        if (result){

            map.put("code",1);
        }else {
            map.put("code",-1);
            map.put("message","注册失败请重试");
        }
        return JSON.toJSONString(map);
    }

    //更新用户数据
    @ResponseBody
    @RequestMapping(value = "/updateUserData",produces = "application/jaon;charset=utf-8")
    public String updateUserData(String userMobile,String userName,String userNum,String userSex,String userIcon){

        User user = userService.queryForMobile(userMobile);
        Map<String,Object> map = new HashMap<>();
        if (user != null){

            user.setUserIcon(userIcon);
            user.setUserName(userName);
            user.setUserNum(userNum);
            user.setUserSex(userSex);

            //开始更新
            boolean result = userService.updateUserData(user);
            if (result){
                map.put("code",1);
                return JSON.toJSONString(map);
            }
        }

        map.put("code",-1);
        return JSON.toJSONString(map);
    }

    //更新密码
    @ResponseBody
    @RequestMapping(value = "/updateUser",produces = "application/json;charset=utf-8")
    public String updateUser(String mobile,String oldPwd,String newPwd){

        User user = userService.queryOneUser(mobile,oldPwd);
        Map<String,Object> map = new HashMap<>();
        if (user != null){
            boolean result = userService.updateUserPwd(mobile,oldPwd,newPwd);
            if (result){

                map.put("code",1);
                return JSON.toJSONString(map);
            }
        }
        map.put("code",-1);
        return JSON.toJSONString(map);
    }
}
