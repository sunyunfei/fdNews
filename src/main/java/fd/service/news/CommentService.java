package fd.service.news;

import fd.dao.news.CommentDao;
import fd.pojo.news.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by syf on 2017/3/7.
 */
@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;
    //插入一条评论
   public boolean insertComment(Comment comment){

        return commentDao.insertComment(comment);
    }

    //查询评论
   public List<Comment> queryComment(Integer newsId){

       return commentDao.queryComment(newsId);
   }
}
