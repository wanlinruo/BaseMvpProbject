package www.wanlinruo.com.basemvpprobject.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

import www.wanlinruo.com.basemvpprobject.http.imageloader.ImageLoader;
import www.wanlinruo.com.basemvpprobject.http.imageloader.glide.ImageConfigImpl;
import www.wanlinruo.com.basemvpprobject.lifecycle.ActivityLifecycleForRxLifecycle;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/6/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class BaseApplication extends Application {

    private ActivityLifecycleForRxLifecycle mActivityLifecycleForRxLifecycle = ActivityLifecycleForRxLifecycle.getInstance();

    private static BaseApplication instance;

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //保存本地变量
        instance = this;

        //注册RxLifecycle
        registerActivityLifecycleCallbacks(mActivityLifecycleForRxLifecycle);

        //初始化CrashHandler
        if (!AppConstant.IS_DEBUG) {
            CrashHandler handler = CrashHandler.getInstance();
            handler.init(this);
            Thread.setDefaultUncaughtExceptionHandler(handler);
        }

        //初始化ARouter页面路由框架
        if (AppConstant.IS_DEBUG) {// 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(getInstance()); // 尽可能早，推荐在Application中初始化


        //使用Chrome看数据库
        //Stetho.initializeWithDefaults(getInstance());

        //设置GreenDao数据库
        //GreenDaoManager.getInstance();

    }

    /**
     * 在模拟环境中程序终止时会被调用
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        if (mActivityLifecycleForRxLifecycle != null) {
            unregisterActivityLifecycleCallbacks(mActivityLifecycleForRxLifecycle);
        }
        mActivityLifecycleForRxLifecycle = null;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        ImageLoader.getInstance().clear(
                getInstance(),
                ImageConfigImpl
                        .builder()
                        .isClearMemory(true)
                        .isClearDiskCache(true)
                        .build());
    }
}
