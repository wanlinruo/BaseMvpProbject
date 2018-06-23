package www.wanlinruo.com.basemvpprobject.utils;

import java.util.ArrayList;
import java.util.List;

import www.wanlinruo.com.basemvpprobject.app.BaseApplication;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/6/23
 *     desc   : 字符串操作工具
 *     version: 1.0
 * </pre>
 */
public class StringUtils {

    public static boolean isNotEmpty(String string) {
        return string != null && !"".equals(string) && !"null".equals(string);
    }

    public static List<String> splitToList(String str) {
        String[] strs = str.split("\\.");
        List<String> list = new ArrayList();
        String[] arr$ = strs;
        int len$ = strs.length;

        for (int i$ = 0; i$ < len$; ++i$) {
            String s = arr$[i$];
            list.add(s);
        }

        return list;
    }

    /**
     * 针对TextView显示中文中出现的排版错乱问题，通过调用此方法得以解决
     *
     * @return 返回全部为全角字符的字符串
     */
    public static String toDBC(String str) {
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375) {
                c[i] = (char) (c[i] - 65248);
            }
        }
        return new String(c);
    }

    /**
     * 累加字符串
     *
     * @return
     */
    public static String toAddStr(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i));
        }
        return builder.toString();
    }

    public static String getResString(int res) {
        return BaseApplication.getInstance().getResources().getString(res);
    }
}
