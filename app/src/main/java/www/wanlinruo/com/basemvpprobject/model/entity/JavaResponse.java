package www.wanlinruo.com.basemvpprobject.model.entity;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/3/20/17:28
 *     desc   : java服务器统一的返回格式
 *     version: 1.0
 * </pre>
 */
public class JavaResponse<T> {

    private int status;//状态码
    private String msg;//提示信息
    private T data;//返回数据

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JavaResponse{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
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
