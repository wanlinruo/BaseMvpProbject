package www.wanlinruo.com.basemvpprobject.http;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/03/28
 *     desc   : 自定义错误
 *     version: 1.0
 * </pre>
 */
public class ApiException extends RuntimeException {
    private int mErrorCode;//错误码

    public ApiException(int errorCode, String errorMessage) {
        super(errorMessage);
        mErrorCode = errorCode;
    }

    public int getErrorCode() {
        return mErrorCode;
    }
}