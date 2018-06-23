package www.wanlinruo.com.basemvpprobject.model.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/6/23
 *     desc   : 上传参数的帮助类
 *     version: 1.0
 * </pre>
 */
public class JavaRequestHelper {
    /**
     * 登录
     *
     * @param phone    手机号
     * @param password 密码
     * @return
     */
    public static Map<String, Object> login(String phone, String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("mobile", phone);
        params.put("password", password);
        return params;
    }

}
