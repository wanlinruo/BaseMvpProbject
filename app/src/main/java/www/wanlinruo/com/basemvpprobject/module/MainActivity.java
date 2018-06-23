package www.wanlinruo.com.basemvpprobject.module;

import android.os.Bundle;

import www.wanlinruo.com.basemvpprobject.R;
import www.wanlinruo.com.basemvpprobject.base.BaseActivity;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/6/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mPresenter.login("18826243441", "123456");
    }
}
