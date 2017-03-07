package fd.dao.news;

import fd.pojo.news.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by syf on 2017/3/7.
 */
public interface CommentDao {

    //插入一条评论
    boolean insertComment(Comment comment);
    //查询评论
    List<Comment> queryComment(@Param("newsId") Integer newsId);
}
