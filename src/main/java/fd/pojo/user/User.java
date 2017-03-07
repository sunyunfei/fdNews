package fd.pojo.user;

/**
 * Created by syf on 2017/3/4.
 */
public class User {
    //用户的属性
    private String userName;
    private String userSex;
    private String userNum;
    private String userMobile;
    private String userPwd;
    private String userIcon;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    @Override
    public String toString() {
        return "User{" +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userNum='" + userNum + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userIcon='" + userIcon + '\'' +
                '}';
    }
}
