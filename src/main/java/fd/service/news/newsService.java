package fd.service.news;

import fd.dao.news.NewsDao;
import fd.pojo.news.News;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by syf on 2017/3/1.
 */
@Service
public class NewsService {

    @Autowired
    private NewsDao newsDao;

    //查询所有新闻
    public List<News> queryNews(String newsType){

        return newsDao.queryNews(newsType);
    }

    //查询某一个新闻
   public News queryOneNews(Integer newsId){

      return newsDao.queryOneNews(newsId);
   }

    //增加浏览量
   public void addRecordForNews(Integer newsId){

       newsDao.addRecordForNews(newsId);
    }
}
