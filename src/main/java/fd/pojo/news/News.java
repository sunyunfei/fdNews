package fd.pojo.news;

/**
 * Created by syf on 2017/3/1.
 */
//新闻表对应的pojo
public class News {

    private Integer newsId;
    private String newsTitle;
    private String newsImage;
    private String newsUrl;
    private int newsComment;
    private int newsBrowse;


    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    public int getNewsComment() {
        return newsComment;
    }

    public void setNewsComment(int newsComment) {
        this.newsComment = newsComment;
    }

    public int getNewsBrowse() {
        return newsBrowse;
    }

    public void setNewsBrowse(int newsBrowse) {
        this.newsBrowse = newsBrowse;
    }


    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsImage='" + newsImage + '\'' +
                ", newsUrl='" + newsUrl + '\'' +
                ", newsComment=" + newsComment +
                ", newsBrowse=" + newsBrowse +
                '}';
    }
}
