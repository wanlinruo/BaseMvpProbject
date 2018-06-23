package www.wanlinruo.com.basemvpprobject.app;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.SystemClock;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.SimpleDateFormat;
import java.util.Date;

import www.wanlinruo.com.basemvpprobject.utils.AppUtils;
import www.wanlinruo.com.basemvpprobject.utils.RxToast;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/6/23
 *     desc   : 异常处理类
 *     version: 1.0
 * </pre>
 */
public class CrashHandler implements UncaughtExceptionHandler {

    /**
     * CrashHandler实例
     */
    private static CrashHandler instance;

    private Context mContext;

    /**
     * 系统默认的UncaughtException处理类
     */
    private UncaughtExceptionHandler mDefaultHandler;

    /**
     * 保证只有一个CrashHandler实例
     */
    private CrashHandler() {
    }

    /**
     * 获取CrashHandler实例 ,单例模式
     */
    synchronized public static CrashHandler getInstance() {
        if (instance == null) {
            instance = new CrashHandler();
        }
        return instance;
    }

    /**
     * 初始化,注册Context对象,
     * 获取系统默认的UncaughtException处理器,
     * 设置该CrashHandler为程序的默认处理器
     *
     * @param context
     */
    public void init(Context context) {
        mContext = context;
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        ex.printStackTrace();
        if (!handleException(ex) && mDefaultHandler != null) {
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            SystemClock.sleep(3000);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(10);
        }
    }

    public boolean handleException(Throwable ex) {
        if (ex == null) {
            return false;
        }

        new Thread() {

            @Override
            public void run() {
                Looper.prepare();
                RxToast.showToast("程序异常退出！");
                Looper.loop();
            }

        }.start();

        saveLog(ex);
        return true;
    }

    private void saveLog(Throwable ex) {

        try {
            File errorDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + AppUtils.getPackageName(BaseApplication.getInstance()) + "/CILogs");
            if (!errorDir.exists()) {
                errorDir.mkdirs();
            }
            //获取当前时间
            long current = System.currentTimeMillis();
            String time = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E").format(new Date(current));

            String crashLogPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + AppUtils.getPackageName(BaseApplication.getInstance()) + "/CILogs/" + time + "_Crash_Log.log";

            File errorFile = new File(crashLogPath);
            errorFile.createNewFile();

            OutputStream out = new FileOutputStream(errorFile, true);

            //写入设备的信息
            //导出手机信息和异常信息
            PackageManager pm = mContext.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(mContext.getPackageName(), PackageManager.GET_ACTIVITIES);
            out.write(("发生异常时间：" + time).getBytes());
            out.write(("应用版本：" + pi.versionName).getBytes());
            out.write(("应用版本号：" + pi.versionCode).getBytes());
            out.write(("android版本号：" + Build.VERSION.RELEASE).getBytes());
            out.write(("android版本号API：" + Build.VERSION.SDK_INT).getBytes());
            out.write(("手机制造商:" + Build.MANUFACTURER).getBytes());
            out.write(("手机型号：" + Build.MODEL).getBytes());
            out.write(("\n\n-----错误分割线" + new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E").format(new Date()) + "-----\n\n").getBytes());
            PrintStream stream = new PrintStream(out);
            ex.printStackTrace(stream);
            stream.flush();
            out.flush();
            stream.close();
            out.close();

            //此时上传错误信息到服务器
            //ApiClient.UploadCrashLog(errorFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}