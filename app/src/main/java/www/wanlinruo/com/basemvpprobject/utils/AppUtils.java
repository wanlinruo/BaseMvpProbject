package www.wanlinruo.com.basemvpprobject.utils;

import android.content.Context;
import android.content.pm.PackageManager;

import java.util.List;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/3/22/17:10
 *     desc   : app基础工具类
 *     version: 1.0
 * </pre>
 */
public class AppUtils {

    /**
     * 获取App版本名称
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }

    /**
     * 获取App版本号
     * @param context
     * @return
     */
    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }

    /**
     * 获取包名
     * @param context
     * @return
     */
    public static String getPackageName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }

    /**
     * 对比两个版本的大小
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion(String version1, String version2) {
        List<String> version1List = StringUtils.splitToList(version1);
        List<String> version2List = StringUtils.splitToList(version2);
        int i;
        int v1;
        if (version1List.size() > version2List.size()) {
            i = version1List.size() - version2List.size();

            for (v1 = 0; v1 < i; ++v1) {
                version2List.add("0");
            }
        } else if (version2List.size() > version1List.size()) {
            i = version2List.size() - version1List.size();

            for (v1 = 0; v1 < i; ++v1) {
                version1List.add("0");
            }
        }

        for (i = 0; i < version1List.size(); ++i) {
            v1 = Integer.parseInt((String) version1List.get(i));
            int v2 = Integer.parseInt((String) version2List.get(i));
            if (v1 > v2) {
                return 1;
            }

            if (v1 < v2) {
                return -1;
            }
        }

        return 0;
    }

    /**
     * 判断是否有读写文件权限
     * @param context
     * @return
     */
    public static boolean checkWriteExternalStoragePermission(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager.checkPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, context.getPackageName()) == PackageManager
                .PERMISSION_GRANTED;
    }
}
