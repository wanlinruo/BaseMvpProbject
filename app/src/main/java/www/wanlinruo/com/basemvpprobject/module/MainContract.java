package www.wanlinruo.com.basemvpprobject.module;


import io.reactivex.Observable;
import www.wanlinruo.com.basemvpprobject.base.IModel;
import www.wanlinruo.com.basemvpprobject.base.IView;
import www.wanlinruo.com.basemvpprobject.model.entity.JavaResponse;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/6/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public interface MainContract {

    interface View extends IView {

    }

    interface Model extends IModel {
        /**
         * 手机账户登录
         *
         * @param phone    手机号码
         * @param password 密码
         * @return
         */
        Observable<JavaResponse<UserBean>> login(String phone, String password);
    }

}
