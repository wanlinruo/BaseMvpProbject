package www.wanlinruo.com.basemvpprobject.http;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import www.wanlinruo.com.basemvpprobject.utils.LogUtil;


/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/6/23
 *     desc   : 拦截器工具类
 *     version: 1.0
 * </pre>
 */
public class InterceptorUtil {

    //日志拦截器
    public static HttpLoggingInterceptor LogInterceptor() {


        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LogUtil.v("—————" + message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);//设置打印数据的级别
    }

    /**
     * 配置retrofit的请求头参数
     *
     * @return
     */
    public static Interceptor InterceptorHead() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                String token = "";
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .header("token", token);
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
    }

}
