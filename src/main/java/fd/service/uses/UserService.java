package fd.service.uses;

import fd.dao.user.UserDao;
import fd.pojo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by syf on 2017/3/4.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    //查询某个
   public User queryOneUser(String mobile, String pwd){

        return userDao.queryOneUser(mobile,pwd);
    }

    @Transactional
    //添加一个
   public Boolean insertUser(String mobile,String pwd){

        return userDao.insertUser(mobile,pwd);
    }

    @Transactional
    //修改一个
   public boolean updateUserPwd(String mobile,String oldPwd,String newPwd){

        return userDao.updateUserPwd(mobile,oldPwd,newPwd);
    }

    @Transactional
    //更新数据
   public boolean updateUserData(User user){

        return userDao.updateUserData(user);
    }

    //根据账号直接查询
    public User queryForMobile(String mobile){

        return userDao.queryForMobile(mobile);
    }

}
