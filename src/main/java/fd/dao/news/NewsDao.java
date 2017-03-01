package fd.dao.news;

import fd.pojo.news.News;

import java.util.List;

/**
 * Created by syf on 2017/3/1.
 */
public interface NewsDao {

    //查询全部
    List<News> queryNews();
}
