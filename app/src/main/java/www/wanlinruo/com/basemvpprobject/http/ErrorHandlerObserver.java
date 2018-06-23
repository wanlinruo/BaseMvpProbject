package www.wanlinruo.com.basemvpprobject.http;

import com.google.gson.stream.MalformedJsonException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import www.wanlinruo.com.basemvpprobject.utils.LogUtil;
import www.wanlinruo.com.basemvpprobject.utils.RxToast;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/6/23
 *     desc   : 公共的异常处理
 *     version: 1.0
 * </pre>
 */
public abstract class ErrorHandlerObserver<T> implements Observer<T> {

    private static final String TAG = "ErrorHandlerObserver";

    @Override
    public void onError(Throwable e) {
        LogUtil.d(TAG, "onError " + e.getMessage());
        if (e instanceof ConnectException) {
            RxToast.showToast("连接超时！请检查您的网络设置");
            _onError("连接超时！请检查您的网络设置");
            return;
        }
        if (e instanceof SocketTimeoutException) {
            RxToast.showToast("连接超时！请检查您的网络设置");
            _onError("连接超时！请检查您的网络设置");
            return;
        }
        if (e instanceof MalformedJsonException) {
            RxToast.showToast("服务器返回JSON格式错误");
            _onError("连接超时！请检查您的网络设置");
            return;
        }
        if (e instanceof UnknownHostException) {
            RxToast.showToast("数据获取失败，请检查您的网络");
            _onError("连接超时！请检查您的网络设置");
            return;
        }
        //添加了自定义错误收集
        if (e instanceof ApiException) {
            ApiException exception = (ApiException) e;
            switch (exception.getErrorCode()) {
                case 400:
                    RxToast.showToast(exception.getMessage());
                    _onError(exception.getMessage());
                    break;
                case 403:
                    RxToast.showToast("登陆已失效,请重新登陆");
                    //跳转登陆界面
                    //ARouter.getInstance().build(ARouterPaths.MAIN_REGISTER).greenChannel().navigation();
                    _onError("登陆已失效,请重新登陆");
                    break;
                case 500:
                    RxToast.showToast(exception.getMessage());
                    _onError(exception.getMessage());
                    break;
            }
            return;
        }


    }

    @Override
    public void onSubscribe(Disposable d) {
        LogUtil.d(TAG, "onSubscribe");
    }

    @Override
    public void onComplete() {
        LogUtil.d(TAG, "onComplete");
    }

    /**
     * 这里处理自定义的错误逻辑
     *
     * @param message
     */
    protected void _onError(String message) {
    }
}
