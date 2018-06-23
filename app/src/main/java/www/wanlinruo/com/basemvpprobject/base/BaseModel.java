package www.wanlinruo.com.basemvpprobject.base;


import www.wanlinruo.com.basemvpprobject.http.RetrofitFactory;


/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/6/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class BaseModel implements IModel {

    protected RetrofitFactory mRetrofitFactory;

    public BaseModel() {
        mRetrofitFactory = RetrofitFactory.getInstance();
    }

}
