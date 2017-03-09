package fd.dao.strategy;

import fd.pojo.strategy.Strategy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by syf on 2017/3/8.
 */
public interface StrategyDao {

    //查询类别
    List<String> queryType();

    //查询某一类型数据
    List<Strategy> queryDataForType(@Param("classes") String type);

    //收藏增加
    boolean addCollectData(@Param("strategyId") Integer strategyId);

    //浏览增加
    boolean addRecordData(@Param("strategyId") Integer strategyId);

    //查询某一条
    Strategy queryOneData(@Param("strategyId") Integer strategyId);
}
