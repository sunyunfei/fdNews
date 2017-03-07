package fd.service.uses;

import fd.dao.user.CollectDao;
import fd.pojo.user.Collect;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by syf on 2017/3/7.
 */
@Service
public class CollectService {

    @Autowired
    private CollectDao collectDao;

    //收藏添加
   public boolean insertCollect(String mobile,Integer newsId){

       return collectDao.insertCollect(mobile,newsId);
   }
    //删除收藏
   public boolean deleteCollect( String mobile, Integer collectId){

       return collectDao.deleteCollect(mobile,collectId);
   }

    //查询
   public List<Collect> queryCollect(String mobile){

       return collectDao.queryCollect(mobile);
   }
}
