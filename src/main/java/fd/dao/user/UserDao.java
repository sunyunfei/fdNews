package fd.dao.user;

import fd.pojo.user.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by syf on 2017/3/4.
 */
public interface UserDao {

    //根据账号直接查询
    User queryForMobile(@Param("userMobile") String mobile);
    //查询某个
    User queryOneUser(@Param("userMobile")String mobile,@Param("userPwd") String pwd);
    //添加一个
    Boolean insertUser(@Param("userMobile")String userMobile,@Param("userPwd") String userPwd);
    //修改密码
    boolean updateUserPwd(@Param("userMobile")String userMobile,@Param("oldPwd") String oldPwd,@Param("newPwd") String newPwd);

    //更新数据
    boolean updateUserData(User user);
}
