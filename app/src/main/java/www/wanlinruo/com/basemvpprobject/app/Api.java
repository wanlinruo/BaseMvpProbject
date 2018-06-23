package www.wanlinruo.com.basemvpprobject.app;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/6/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Api {

    //网络协议
    private final static String HTTP = "http://";
    private final static String HTTPS = "https://";

    /**
     * 正式环境
     */
    private static final String SERVER_IP = "47.97.123.158:8880";
    public static final String JAVA_DOMAIN_NAME = "formal";//正式服务器标示，用于retrofit的BaseUrl切换
    public static final String APP_JAVA_DOMAIN = HTTPS + SERVER_IP;

    /**
     * 测试环境
     */
    private static final String TEST_SERVER_IP = "47.97.123.158:8880";
    public static final String JAVA_DOMAIN_TEST = "test";//测试服务器标示，用于retrofit的BaseUrl切换
    public static final String APP_JAVA_DOMAIN_TEST = HTTPS + TEST_SERVER_IP;

    /**
     * 本地测试环境
     */
    private static final String LOCAL_TEST_SERVER_IP = "172.16.1.28:8883";
    public static final String JAVA_DOMAIN_LOCAL_TEST = "local_test";//本地测试服务器标示，用于retrofit的BaseUrl切换
    public static final String APP_JAVA_DOMAIN_LOCAL_TEST = HTTPS + LOCAL_TEST_SERVER_IP;

    //服务器接口版本
    public final static String VERSION_4_0_0 = "/v4_0_0";


    //----------------------------------- 3.2 新增接口 -----------------------------------------------

    //登录接口
    public static final String LOGIN_LIST_URL = VERSION_4_0_0 + "/user/login";

}
