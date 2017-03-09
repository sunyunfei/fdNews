package fd.dao.user;

import fd.pojo.user.StrategyCollect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by syf on 2017/3/9.
 */
public interface StrategyCollectDao {

    //收藏添加
    boolean insertCollect(@Param("userMobile") String mobile, @Param("strategyId") Integer strategyId);
    //删除收藏
    boolean deleteCollect(@Param("userMobile") String mobile,@Param("collectId") Integer collectId);

    //查询
    List<StrategyCollect> queryCollect(@Param("userMobile") String mobile);

    //查询单个
    StrategyCollect queryOneCollect(@Param("strategyId") Integer strategyId);
}
