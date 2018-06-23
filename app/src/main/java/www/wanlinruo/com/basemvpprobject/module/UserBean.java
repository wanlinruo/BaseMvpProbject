package www.wanlinruo.com.basemvpprobject.module;

import java.io.Serializable;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/03/22
 *     desc   : 用户信息bean
 *     version: 1.0
 * </pre>
 */
public class UserBean implements Serializable {

    private String id;//用户id

    private String token;//唯一标识

    private String mobile; //手机号码

    private String showName;//用户名称

    private String picUrl;//用户头像

    private int bindWeixin;//是否绑定微信

    private int bindWeibo;//是否绑定微博

    private int bindQq;//是否绑定QQ

    public int getBindWeixin() {
        return bindWeixin;
    }

    public void setBindWeixin(int bindWeixin) {
        this.bindWeixin = bindWeixin;
    }

    public int getBindWeibo() {
        return bindWeibo;
    }

    public void setBindWeibo(int bindWeibo) {
        this.bindWeibo = bindWeibo;
    }

    public int getBindQq() {
        return bindQq;
    }

    public void setBindQq(int bindQq) {
        this.bindQq = bindQq;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userId=" + id +
                ", token=" + token +
                ", showName='" + showName + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", bindWeixin=" + bindWeixin +
                ", bindWeibo=" + bindWeibo +
                ", bindQq=" + bindQq +
                '}';
    }

    //==========================自定义方法,不参与解析==========================
    public boolean isBindWeixin() {
        return bindWeixin == 1;
    }

    public boolean isBindWeibo() {
        return bindWeibo == 1;
    }

    public boolean isBindQq() {
        return bindQq == 1;
    }
    //==========================自定义方法,不参与解析==========================
}
