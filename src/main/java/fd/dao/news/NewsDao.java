package fd.dao.news;

import fd.pojo.news.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by syf on 2017/3/1.
 */
public interface NewsDao {

    //查询某一类型全部
    List<News> queryNews(@Param("newsType") String newsType);
    //查询某一个新闻
    News queryOneNews(@Param("newsId") Integer newsId);

    //增加浏览量
    void addRecordForNews(@Param("newsId") Integer newsId);
}
