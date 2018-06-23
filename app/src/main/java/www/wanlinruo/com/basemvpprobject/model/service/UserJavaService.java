package www.wanlinruo.com.basemvpprobject.model.service;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import www.wanlinruo.com.basemvpprobject.app.Api;
import www.wanlinruo.com.basemvpprobject.model.entity.JavaResponse;
import www.wanlinruo.com.basemvpprobject.module.UserBean;

import static www.wanlinruo.com.basemvpprobject.app.Api.JAVA_DOMAIN_NAME;
import static www.wanlinruo.com.basemvpprobject.http.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/3/20/17:28
 *     desc   : 接口
 *     version: 1.0
 * </pre>
 */
public interface UserJavaService {

    //登陆
    @Headers({DOMAIN_NAME_HEADER + JAVA_DOMAIN_NAME})
    @FormUrlEncoded//用于修饰Field注解和FieldMap注解
    @POST(Api.LOGIN_LIST_URL)
    Observable<JavaResponse<UserBean>> login(@FieldMap Map<String, Object> params);

}
