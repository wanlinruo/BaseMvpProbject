package www.wanlinruo.com.basemvpprobject.module;

import java.util.Map;

import io.reactivex.Observable;
import www.wanlinruo.com.basemvpprobject.base.BaseModel;
import www.wanlinruo.com.basemvpprobject.model.entity.JavaResponse;
import www.wanlinruo.com.basemvpprobject.model.helper.JavaRequestHelper;
import www.wanlinruo.com.basemvpprobject.model.service.UserJavaService;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/6/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class MainModel extends BaseModel implements MainContract.Model {

    @Override
    public Observable<JavaResponse<UserBean>> login(String phone, String password) {
        Map<String, Object> params = JavaRequestHelper.login(phone, password);
        return mRetrofitFactory.obtainRetrofitService(UserJavaService.class)
                .login(params);
    }
}
