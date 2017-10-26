package lzf.gank.app;

import android.app.Application;

//import com.squareup.leakcanary.LeakCanary;

/**
 * Created by lizhifeng on 2017/10/26 0026.
 */

public class GankApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        LeakCanary.install(this);
    }
}
