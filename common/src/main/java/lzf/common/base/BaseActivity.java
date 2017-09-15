package lzf.common.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    //是否是第一次进入 防止onResume重新请求数据
    private boolean isFirstComing = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initVariable();
        initListener();
    }

    @Override
    public void initVariable() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isFirstComing) {
            isFirstComing = false;
            loadData();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        /**
         * 低内存 只保留栈顶activity
         * */
        ActivityManager.getAppManager().onLowMemory();
    }
}
