package www.wanlinruo.com.basemvpprobject.utils;

import android.util.Log;

import www.wanlinruo.com.basemvpprobject.app.AppConstant;


/**
 * LogUtil
 */
public class LogUtil {

    // 是否需要打印bug
    private static final String TAG = "LogUtil";

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (AppConstant.IS_DEBUG) {
            Log.i(TAG, msg);
        }
    }

    public static void d(String msg) {
        if (AppConstant.IS_DEBUG) {
            Log.d(TAG, msg);
        }
    }

    public static void e(String msg) {
        if (AppConstant.IS_DEBUG) {
            Log.e(TAG, msg);
        }
    }

    public static void v(String msg) {
        if (AppConstant.IS_DEBUG) {
            Log.v(TAG, msg);
        }
    }

    public static void w(String msg) {
        if (AppConstant.IS_DEBUG) {
            Log.w(TAG, msg);
        }
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (AppConstant.IS_DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (AppConstant.IS_DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (AppConstant.IS_DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (AppConstant.IS_DEBUG) {
            Log.v(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (AppConstant.IS_DEBUG) {
            Log.w(tag, msg);
        }
    }
}
