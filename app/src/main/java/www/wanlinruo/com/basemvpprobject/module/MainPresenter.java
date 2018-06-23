package www.wanlinruo.com.basemvpprobject.module;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import www.wanlinruo.com.basemvpprobject.base.BasePresenter;
import www.wanlinruo.com.basemvpprobject.http.ErrorHandlerObserver;
import www.wanlinruo.com.basemvpprobject.lifecycle.RxLifecycleUtils;
import www.wanlinruo.com.basemvpprobject.model.entity.JavaResponse;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/6/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> {

    public MainPresenter(MainContract.View rootView) {
        super(new MainModel(), rootView);
    }

    public void login(String phone, String password) {
        mModel.login(phone, password)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> {
                    mRootView.showLoading();
                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {
                    mRootView.hideLoading();
                })
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                .subscribe(new ErrorHandlerObserver<JavaResponse<UserBean>>() {
                    @Override
                    public void onNext(JavaResponse<UserBean> javaResponse) {
                        if (javaResponse != null) {
                            //通知
                            mRootView.showMessage(javaResponse.getMsg());
                        }
                    }
                });
    }
}
