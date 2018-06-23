package www.wanlinruo.com.basemvpprobject.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/6/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public interface IFragment<P extends IPresenter> {

    /**
     * 初始化View，不为null时会调用{@link butterknife.ButterKnife#bind(View)} (int)}
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * 初始化数据
     *
     * @param savedInstanceState
     */
    void initData(Bundle savedInstanceState);

    /**
     * 初始化Presenter
     *
     * @return
     */
    P initPresenter();
}
