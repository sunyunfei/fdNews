package fd.pojo.user;

/**
 * Created by syf on 2017/3/7.
 */
public class Collect {
    private Integer collectId;
    private Integer newsId;
    private String userMobile;

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "collectId=" + collectId +
                ", newsId=" + newsId +
                ", userMobile='" + userMobile + '\'' +
                '}';
    }
}
