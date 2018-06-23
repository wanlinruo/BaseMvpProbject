package www.wanlinruo.com.basemvpprobject.app;


import org.greenrobot.eventbus.EventBus;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/6/23
 *     desc   : 集中EventBus，方便查找，并统一使用Message来调用{@link EventBus#post(Object)}
 *     version: 1.0
 * </pre>
 */
public class EventBusTags {

    private static final int WAN_LIN_RUO = 1000;

    //关闭其他页面，只保留主页面
    public static final int CLOSE_ALL_KEEP_THE_HOME = WAN_LIN_RUO + 1;
}
