package fd.service.strategy;

import fd.dao.strategy.StrategyDao;
import fd.pojo.strategy.Strategy;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by syf on 2017/3/8.
 */
@Service
public class StrategyService {

    @Autowired
    private StrategyDao strategyDao;

    //查询类别
   public List<String> queryType(){

       return strategyDao.queryType();
   }

    //查询某一类型数据
   public List<Strategy> queryDataForType(String type){

      return strategyDao.queryDataForType(type);
   }

    //收藏增加
    @Transactional
   public boolean addCollectData(Integer strategyId){

       return strategyDao.addCollectData(strategyId);
   }

    //浏览增加
    @Transactional
   public boolean addRecordData(Integer strategyId){

       return strategyDao.addRecordData(strategyId);
   }

    //查询某一条
    public Strategy queryOneData(Integer strategyId){

        return strategyDao.queryOneData(strategyId);
    }
}
