package fd.pojo.news;

/**
 * Created by syf on 2017/3/7.
 */
public class Comment {
    private Integer commentId;
    private String content;
    private String createTime;
    private String userMobile;
    private Integer newsId;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", newsId=" + newsId +
                '}';
    }
}
