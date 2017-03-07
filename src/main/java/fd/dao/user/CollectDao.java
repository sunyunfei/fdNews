package fd.dao.user;

import fd.pojo.user.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by syf on 2017/3/7.
 */
public interface CollectDao {

    //收藏添加
    boolean insertCollect(@Param("userMobile") String mobile,@Param("newsId") Integer newsId);
    //删除收藏
    boolean deleteCollect(@Param("userMobile") String mobile,@Param("collectId") Integer collectId);

    //查询
    List<Collect> queryCollect(@Param("userMobile") String mobile);
}
