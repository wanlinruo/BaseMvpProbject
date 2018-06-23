package www.wanlinruo.com.basemvpprobject.http;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import www.wanlinruo.com.basemvpprobject.http.GsonConverterFactory.CustomGsonConverterFactory;
import www.wanlinruo.com.basemvpprobject.http.retrofiturlmanager.RetrofitUrlManager;

import static www.wanlinruo.com.basemvpprobject.app.Api.APP_JAVA_DOMAIN;
import static www.wanlinruo.com.basemvpprobject.app.Api.APP_JAVA_DOMAIN_LOCAL_TEST;
import static www.wanlinruo.com.basemvpprobject.app.Api.APP_JAVA_DOMAIN_TEST;
import static www.wanlinruo.com.basemvpprobject.app.Api.JAVA_DOMAIN_LOCAL_TEST;
import static www.wanlinruo.com.basemvpprobject.app.Api.JAVA_DOMAIN_NAME;
import static www.wanlinruo.com.basemvpprobject.app.Api.JAVA_DOMAIN_TEST;


public class RetrofitFactory {

    private static RetrofitFactory mRetrofitFactory;
    private Retrofit mRetrofit;

    private RetrofitFactory() {
        //将每个 BaseUrl 进行初始化,运行时可以随时改变 DOMAIN_NAME 对应的值,从而达到改变 BaseUrl 的效果
        RetrofitUrlManager.getInstance().putDomain(JAVA_DOMAIN_NAME, APP_JAVA_DOMAIN);
        RetrofitUrlManager.getInstance().putDomain(JAVA_DOMAIN_TEST, APP_JAVA_DOMAIN_TEST); //测试环境
        RetrofitUrlManager.getInstance().putDomain(JAVA_DOMAIN_LOCAL_TEST, APP_JAVA_DOMAIN_LOCAL_TEST); //测试环境


        OkHttpClient mOkHttpClient = RetrofitUrlManager.getInstance().with(new OkHttpClient.Builder()) //RetrofitUrlManager 初始化
                .addInterceptor(InterceptorUtil.LogInterceptor())//添加日志拦截器
                .addInterceptor(InterceptorUtil.InterceptorHead())
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(APP_JAVA_DOMAIN)
                .addConverterFactory(CustomGsonConverterFactory.create())//添加gson转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava转换器
                .client(mOkHttpClient)
                .build();
    }

    public static RetrofitFactory getInstance() {
        if (mRetrofitFactory == null) {
            synchronized (RetrofitFactory.class) {
                if (mRetrofitFactory == null)
                    mRetrofitFactory = new RetrofitFactory();
            }
        }
        return mRetrofitFactory;
    }

    public <T> T obtainRetrofitService(final Class<T> service) {
        return mRetrofit.create(service);
    }
}
