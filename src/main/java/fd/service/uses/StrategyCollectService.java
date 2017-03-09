package fd.service.uses;

import fd.dao.user.StrategyCollectDao;
import fd.pojo.user.StrategyCollect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by syf on 2017/3/9.
 */
@Service
public class StrategyCollectService {

    @Autowired
    private StrategyCollectDao strategyCollectDao;
    //收藏添加
   public boolean insertCollect(String mobile, Integer strategyId){

       return strategyCollectDao.insertCollect(mobile,strategyId);
   }
    //删除收藏
   public boolean deleteCollect(String mobile,Integer collectId){

       return strategyCollectDao.deleteCollect(mobile,collectId);
   }

    //查询
   public List<StrategyCollect> queryCollect(String mobile){

       return strategyCollectDao.queryCollect(mobile);
   }

    //查询单个
   public StrategyCollect queryOneCollect(Integer strategyId){

       return strategyCollectDao.queryOneCollect(strategyId);
   }
}
