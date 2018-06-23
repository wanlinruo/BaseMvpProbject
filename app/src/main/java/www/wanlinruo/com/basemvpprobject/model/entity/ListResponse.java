package www.wanlinruo.com.basemvpprobject.model.entity;

import java.util.List;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/3/20/17:28
 *     desc   : java服务器统一的返回格式
 *     version: 1.0
 * </pre>
 */
public class ListResponse<T> {

    private int status;//状态码
    private String msg;//提示信息
    private List<T> data;//返回数据

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    /**
     * API是否请求失败
     *
     * @return 失败返回true, 成功返回false
     */
    public boolean isSuccess() {
        return status == 200;
    }
}
